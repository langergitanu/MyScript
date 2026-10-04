package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.fileproperties.PropertyGroup;
import com.dropbox.core.p013v2.files.ExportInfo;
import com.dropbox.core.p013v2.files.FileLockMetadata;
import com.dropbox.core.p013v2.files.FileSharingInfo;
import com.dropbox.core.p013v2.files.MediaInfo;
import com.dropbox.core.p013v2.files.Metadata;
import com.dropbox.core.p013v2.files.SymlinkInfo;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class FileMetadata extends Metadata {

    @Nonnull
    protected final Date clientModified;

    @Nullable
    protected final String contentHash;

    @Nullable
    protected final ExportInfo exportInfo;

    @Nullable
    protected final FileLockMetadata fileLockInfo;

    @Nullable
    protected final Boolean hasExplicitSharedMembers;

    /* JADX INFO: renamed from: id */
    @Nonnull
    protected final String f695id;
    protected final boolean isDownloadable;

    @Nullable
    protected final MediaInfo mediaInfo;

    @Nullable
    protected final List<PropertyGroup> propertyGroups;

    @Nonnull
    protected final String rev;

    @Nonnull
    protected final Date serverModified;

    @Nullable
    protected final FileSharingInfo sharingInfo;
    protected final long size;

    @Nullable
    protected final SymlinkInfo symlinkInfo;

    public FileMetadata(@Nonnull String str, @Nonnull String str2, @Nonnull Date date, @Nonnull Date date2, @Nonnull String str3, long j, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable MediaInfo mediaInfo, @Nullable SymlinkInfo symlinkInfo, @Nullable FileSharingInfo fileSharingInfo, boolean z, @Nullable ExportInfo exportInfo, @Nullable List<PropertyGroup> list, @Nullable Boolean bool, @Nullable String str8, @Nullable FileLockMetadata fileLockMetadata) {
        super(str, str4, str5, str6, str7);
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'id' is null");
        }
        if (str2.length() < 1) {
            throw new IllegalArgumentException("String 'id' is shorter than 1");
        }
        this.f695id = str2;
        if (date == null) {
            throw new IllegalArgumentException("Required value for 'clientModified' is null");
        }
        this.clientModified = LangUtil.truncateMillis(date);
        if (date2 == null) {
            throw new IllegalArgumentException("Required value for 'serverModified' is null");
        }
        this.serverModified = LangUtil.truncateMillis(date2);
        if (str3 == null) {
            throw new IllegalArgumentException("Required value for 'rev' is null");
        }
        if (str3.length() < 9) {
            throw new IllegalArgumentException("String 'rev' is shorter than 9");
        }
        if (!Pattern.matches("[0-9a-f]+", str3)) {
            throw new IllegalArgumentException("String 'rev' does not match pattern");
        }
        this.rev = str3;
        this.size = j;
        this.mediaInfo = mediaInfo;
        this.symlinkInfo = symlinkInfo;
        this.sharingInfo = fileSharingInfo;
        this.isDownloadable = z;
        this.exportInfo = exportInfo;
        if (list != null) {
            Iterator<PropertyGroup> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'propertyGroups' is null");
                }
            }
        }
        this.propertyGroups = list;
        this.hasExplicitSharedMembers = bool;
        if (str8 != null) {
            if (str8.length() < 64) {
                throw new IllegalArgumentException("String 'contentHash' is shorter than 64");
            }
            if (str8.length() > 64) {
                throw new IllegalArgumentException("String 'contentHash' is longer than 64");
            }
        }
        this.contentHash = str8;
        this.fileLockInfo = fileLockMetadata;
    }

    public FileMetadata(@Nonnull String str, @Nonnull String str2, @Nonnull Date date, @Nonnull Date date2, @Nonnull String str3, long j) {
        this(str, str2, date, date2, str3, j, null, null, null, null, null, null, null, true, null, null, null, null, null);
    }

    @Override // com.dropbox.core.p013v2.files.Metadata
    @Nonnull
    public String getName() {
        return this.name;
    }

    @Nonnull
    public String getId() {
        return this.f695id;
    }

    @Nonnull
    public Date getClientModified() {
        return this.clientModified;
    }

    @Nonnull
    public Date getServerModified() {
        return this.serverModified;
    }

    @Nonnull
    public String getRev() {
        return this.rev;
    }

    public long getSize() {
        return this.size;
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
    public MediaInfo getMediaInfo() {
        return this.mediaInfo;
    }

    @Nullable
    public SymlinkInfo getSymlinkInfo() {
        return this.symlinkInfo;
    }

    @Nullable
    public FileSharingInfo getSharingInfo() {
        return this.sharingInfo;
    }

    public boolean getIsDownloadable() {
        return this.isDownloadable;
    }

    @Nullable
    public ExportInfo getExportInfo() {
        return this.exportInfo;
    }

    @Nullable
    public List<PropertyGroup> getPropertyGroups() {
        return this.propertyGroups;
    }

    @Nullable
    public Boolean getHasExplicitSharedMembers() {
        return this.hasExplicitSharedMembers;
    }

    @Nullable
    public String getContentHash() {
        return this.contentHash;
    }

    @Nullable
    public FileLockMetadata getFileLockInfo() {
        return this.fileLockInfo;
    }

    public static Builder newBuilder(String str, String str2, Date date, Date date2, String str3, long j) {
        return new Builder(str, str2, date, date2, str3, j);
    }

    public static class Builder extends Metadata.Builder {
        protected final Date clientModified;
        protected String contentHash;
        protected ExportInfo exportInfo;
        protected FileLockMetadata fileLockInfo;
        protected Boolean hasExplicitSharedMembers;

        /* JADX INFO: renamed from: id */
        protected final String f696id;
        protected boolean isDownloadable;
        protected MediaInfo mediaInfo;
        protected List<PropertyGroup> propertyGroups;
        protected final String rev;
        protected final Date serverModified;
        protected FileSharingInfo sharingInfo;
        protected final long size;
        protected SymlinkInfo symlinkInfo;

        protected Builder(String str, String str2, Date date, Date date2, String str3, long j) {
            super(str);
            if (str2 == null) {
                throw new IllegalArgumentException("Required value for 'id' is null");
            }
            if (str2.length() < 1) {
                throw new IllegalArgumentException("String 'id' is shorter than 1");
            }
            this.f696id = str2;
            if (date == null) {
                throw new IllegalArgumentException("Required value for 'clientModified' is null");
            }
            this.clientModified = LangUtil.truncateMillis(date);
            if (date2 == null) {
                throw new IllegalArgumentException("Required value for 'serverModified' is null");
            }
            this.serverModified = LangUtil.truncateMillis(date2);
            if (str3 == null) {
                throw new IllegalArgumentException("Required value for 'rev' is null");
            }
            if (str3.length() < 9) {
                throw new IllegalArgumentException("String 'rev' is shorter than 9");
            }
            if (!Pattern.matches("[0-9a-f]+", str3)) {
                throw new IllegalArgumentException("String 'rev' does not match pattern");
            }
            this.rev = str3;
            this.size = j;
            this.mediaInfo = null;
            this.symlinkInfo = null;
            this.sharingInfo = null;
            this.isDownloadable = true;
            this.exportInfo = null;
            this.propertyGroups = null;
            this.hasExplicitSharedMembers = null;
            this.contentHash = null;
            this.fileLockInfo = null;
        }

        public Builder withMediaInfo(MediaInfo mediaInfo) {
            this.mediaInfo = mediaInfo;
            return this;
        }

        public Builder withSymlinkInfo(SymlinkInfo symlinkInfo) {
            this.symlinkInfo = symlinkInfo;
            return this;
        }

        public Builder withSharingInfo(FileSharingInfo fileSharingInfo) {
            this.sharingInfo = fileSharingInfo;
            return this;
        }

        public Builder withIsDownloadable(Boolean bool) {
            if (bool != null) {
                this.isDownloadable = bool.booleanValue();
                return this;
            }
            this.isDownloadable = true;
            return this;
        }

        public Builder withExportInfo(ExportInfo exportInfo) {
            this.exportInfo = exportInfo;
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

        public Builder withHasExplicitSharedMembers(Boolean bool) {
            this.hasExplicitSharedMembers = bool;
            return this;
        }

        public Builder withContentHash(String str) {
            if (str != null) {
                if (str.length() < 64) {
                    throw new IllegalArgumentException("String 'contentHash' is shorter than 64");
                }
                if (str.length() > 64) {
                    throw new IllegalArgumentException("String 'contentHash' is longer than 64");
                }
            }
            this.contentHash = str;
            return this;
        }

        public Builder withFileLockInfo(FileLockMetadata fileLockMetadata) {
            this.fileLockInfo = fileLockMetadata;
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
        public FileMetadata build() {
            return new FileMetadata(this.name, this.f696id, this.clientModified, this.serverModified, this.rev, this.size, this.pathLower, this.pathDisplay, this.parentSharedFolderId, this.previewUrl, this.mediaInfo, this.symlinkInfo, this.sharingInfo, this.isDownloadable, this.exportInfo, this.propertyGroups, this.hasExplicitSharedMembers, this.contentHash, this.fileLockInfo);
        }
    }

    @Override // com.dropbox.core.p013v2.files.Metadata
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.f695id, this.clientModified, this.serverModified, this.rev, Long.valueOf(this.size), this.mediaInfo, this.symlinkInfo, this.sharingInfo, Boolean.valueOf(this.isDownloadable), this.exportInfo, this.propertyGroups, this.hasExplicitSharedMembers, this.contentHash, this.fileLockInfo});
    }

    @Override // com.dropbox.core.p013v2.files.Metadata
    public boolean equals(Object obj) {
        String str;
        String str2;
        Date date;
        Date date2;
        Date date3;
        Date date4;
        String str3;
        String str4;
        MediaInfo mediaInfo;
        MediaInfo mediaInfo2;
        SymlinkInfo symlinkInfo;
        SymlinkInfo symlinkInfo2;
        FileSharingInfo fileSharingInfo;
        FileSharingInfo fileSharingInfo2;
        ExportInfo exportInfo;
        ExportInfo exportInfo2;
        List<PropertyGroup> list;
        List<PropertyGroup> list2;
        Boolean bool;
        Boolean bool2;
        String str5;
        String str6;
        FileLockMetadata fileLockMetadata;
        FileLockMetadata fileLockMetadata2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            FileMetadata fileMetadata = (FileMetadata) obj;
            if ((this.name == fileMetadata.name || this.name.equals(fileMetadata.name)) && (((str = this.f695id) == (str2 = fileMetadata.f695id) || str.equals(str2)) && (((date = this.clientModified) == (date2 = fileMetadata.clientModified) || date.equals(date2)) && (((date3 = this.serverModified) == (date4 = fileMetadata.serverModified) || date3.equals(date4)) && (((str3 = this.rev) == (str4 = fileMetadata.rev) || str3.equals(str4)) && this.size == fileMetadata.size && ((this.pathLower == fileMetadata.pathLower || (this.pathLower != null && this.pathLower.equals(fileMetadata.pathLower))) && ((this.pathDisplay == fileMetadata.pathDisplay || (this.pathDisplay != null && this.pathDisplay.equals(fileMetadata.pathDisplay))) && ((this.parentSharedFolderId == fileMetadata.parentSharedFolderId || (this.parentSharedFolderId != null && this.parentSharedFolderId.equals(fileMetadata.parentSharedFolderId))) && ((this.previewUrl == fileMetadata.previewUrl || (this.previewUrl != null && this.previewUrl.equals(fileMetadata.previewUrl))) && (((mediaInfo = this.mediaInfo) == (mediaInfo2 = fileMetadata.mediaInfo) || (mediaInfo != null && mediaInfo.equals(mediaInfo2))) && (((symlinkInfo = this.symlinkInfo) == (symlinkInfo2 = fileMetadata.symlinkInfo) || (symlinkInfo != null && symlinkInfo.equals(symlinkInfo2))) && (((fileSharingInfo = this.sharingInfo) == (fileSharingInfo2 = fileMetadata.sharingInfo) || (fileSharingInfo != null && fileSharingInfo.equals(fileSharingInfo2))) && this.isDownloadable == fileMetadata.isDownloadable && (((exportInfo = this.exportInfo) == (exportInfo2 = fileMetadata.exportInfo) || (exportInfo != null && exportInfo.equals(exportInfo2))) && (((list = this.propertyGroups) == (list2 = fileMetadata.propertyGroups) || (list != null && list.equals(list2))) && (((bool = this.hasExplicitSharedMembers) == (bool2 = fileMetadata.hasExplicitSharedMembers) || (bool != null && bool.equals(bool2))) && (((str5 = this.contentHash) == (str6 = fileMetadata.contentHash) || (str5 != null && str5.equals(str6))) && ((fileLockMetadata = this.fileLockInfo) == (fileLockMetadata2 = fileMetadata.fileLockInfo) || (fileLockMetadata != null && fileLockMetadata.equals(fileLockMetadata2))))))))))))))))))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.dropbox.core.p013v2.files.Metadata
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.files.Metadata
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FileMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FileMetadata fileMetadata, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            writeTag("file", jsonGenerator);
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(fileMetadata.name, jsonGenerator);
            jsonGenerator.writeFieldName("id");
            StoneSerializers.string().serialize(fileMetadata.f695id, jsonGenerator);
            jsonGenerator.writeFieldName("client_modified");
            StoneSerializers.timestamp().serialize(fileMetadata.clientModified, jsonGenerator);
            jsonGenerator.writeFieldName("server_modified");
            StoneSerializers.timestamp().serialize(fileMetadata.serverModified, jsonGenerator);
            jsonGenerator.writeFieldName("rev");
            StoneSerializers.string().serialize(fileMetadata.rev, jsonGenerator);
            jsonGenerator.writeFieldName("size");
            StoneSerializers.uInt64().serialize(Long.valueOf(fileMetadata.size), jsonGenerator);
            if (fileMetadata.pathLower != null) {
                jsonGenerator.writeFieldName("path_lower");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(fileMetadata.pathLower, jsonGenerator);
            }
            if (fileMetadata.pathDisplay != null) {
                jsonGenerator.writeFieldName("path_display");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(fileMetadata.pathDisplay, jsonGenerator);
            }
            if (fileMetadata.parentSharedFolderId != null) {
                jsonGenerator.writeFieldName("parent_shared_folder_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(fileMetadata.parentSharedFolderId, jsonGenerator);
            }
            if (fileMetadata.previewUrl != null) {
                jsonGenerator.writeFieldName("preview_url");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(fileMetadata.previewUrl, jsonGenerator);
            }
            if (fileMetadata.mediaInfo != null) {
                jsonGenerator.writeFieldName("media_info");
                StoneSerializers.nullable(MediaInfo.Serializer.INSTANCE).serialize(fileMetadata.mediaInfo, jsonGenerator);
            }
            if (fileMetadata.symlinkInfo != null) {
                jsonGenerator.writeFieldName("symlink_info");
                StoneSerializers.nullableStruct(SymlinkInfo.Serializer.INSTANCE).serialize(fileMetadata.symlinkInfo, jsonGenerator);
            }
            if (fileMetadata.sharingInfo != null) {
                jsonGenerator.writeFieldName("sharing_info");
                StoneSerializers.nullableStruct(FileSharingInfo.Serializer.INSTANCE).serialize(fileMetadata.sharingInfo, jsonGenerator);
            }
            jsonGenerator.writeFieldName("is_downloadable");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(fileMetadata.isDownloadable), jsonGenerator);
            if (fileMetadata.exportInfo != null) {
                jsonGenerator.writeFieldName("export_info");
                StoneSerializers.nullableStruct(ExportInfo.Serializer.INSTANCE).serialize(fileMetadata.exportInfo, jsonGenerator);
            }
            if (fileMetadata.propertyGroups != null) {
                jsonGenerator.writeFieldName("property_groups");
                StoneSerializers.nullable(StoneSerializers.list(PropertyGroup.Serializer.INSTANCE)).serialize(fileMetadata.propertyGroups, jsonGenerator);
            }
            if (fileMetadata.hasExplicitSharedMembers != null) {
                jsonGenerator.writeFieldName("has_explicit_shared_members");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(fileMetadata.hasExplicitSharedMembers, jsonGenerator);
            }
            if (fileMetadata.contentHash != null) {
                jsonGenerator.writeFieldName("content_hash");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(fileMetadata.contentHash, jsonGenerator);
            }
            if (fileMetadata.fileLockInfo != null) {
                jsonGenerator.writeFieldName("file_lock_info");
                StoneSerializers.nullableStruct(FileLockMetadata.Serializer.INSTANCE).serialize(fileMetadata.fileLockInfo, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0014  */
        @Override // com.dropbox.core.stone.StructSerializer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public FileMetadata deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Long lDeserialize = null;
            if (!z) {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                if ("file".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                Boolean boolDeserialize = true;
                String strDeserialize = null;
                String strDeserialize2 = null;
                Date dateDeserialize = null;
                Date dateDeserialize2 = null;
                String strDeserialize3 = null;
                String str = null;
                String str2 = null;
                String str3 = null;
                String str4 = null;
                MediaInfo mediaInfo = null;
                SymlinkInfo symlinkInfo = null;
                FileSharingInfo fileSharingInfo = null;
                ExportInfo exportInfo = null;
                List list = null;
                Boolean bool = null;
                String str5 = null;
                FileLockMetadata fileLockMetadata = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("id".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("client_modified".equals(currentName)) {
                        dateDeserialize = StoneSerializers.timestamp().deserialize(jsonParser);
                    } else if ("server_modified".equals(currentName)) {
                        dateDeserialize2 = StoneSerializers.timestamp().deserialize(jsonParser);
                    } else if ("rev".equals(currentName)) {
                        strDeserialize3 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("size".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else if ("path_lower".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("path_display".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("parent_shared_folder_id".equals(currentName)) {
                        str3 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("preview_url".equals(currentName)) {
                        str4 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("media_info".equals(currentName)) {
                        mediaInfo = (MediaInfo) StoneSerializers.nullable(MediaInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("symlink_info".equals(currentName)) {
                        symlinkInfo = (SymlinkInfo) StoneSerializers.nullableStruct(SymlinkInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("sharing_info".equals(currentName)) {
                        fileSharingInfo = (FileSharingInfo) StoneSerializers.nullableStruct(FileSharingInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("is_downloadable".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("export_info".equals(currentName)) {
                        exportInfo = (ExportInfo) StoneSerializers.nullableStruct(ExportInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("property_groups".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(PropertyGroup.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else if ("has_explicit_shared_members".equals(currentName)) {
                        bool = (Boolean) StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(jsonParser);
                    } else if ("content_hash".equals(currentName)) {
                        str5 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("file_lock_info".equals(currentName)) {
                        fileLockMetadata = (FileLockMetadata) StoneSerializers.nullableStruct(FileLockMetadata.Serializer.INSTANCE).deserialize(jsonParser);
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
                if (dateDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"client_modified\" missing.");
                }
                if (dateDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"server_modified\" missing.");
                }
                if (strDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"rev\" missing.");
                }
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"size\" missing.");
                }
                FileMetadata fileMetadata = new FileMetadata(strDeserialize, strDeserialize2, dateDeserialize, dateDeserialize2, strDeserialize3, lDeserialize.longValue(), str, str2, str3, str4, mediaInfo, symlinkInfo, fileSharingInfo, boolDeserialize.booleanValue(), exportInfo, list, bool, str5, fileLockMetadata);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(fileMetadata, fileMetadata.toStringMultiline());
                return fileMetadata;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
