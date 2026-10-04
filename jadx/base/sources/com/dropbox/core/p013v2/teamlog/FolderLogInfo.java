package com.dropbox.core.p013v2.teamlog;

import androidx.core.provider.FontsContractCompat;
import com.dropbox.core.p013v2.teamlog.FileOrFolderLogInfo;
import com.dropbox.core.p013v2.teamlog.PathLogInfo;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes5.dex */
public class FolderLogInfo extends FileOrFolderLogInfo {

    @Nullable
    protected final Long fileCount;

    public FolderLogInfo(@Nonnull PathLogInfo pathLogInfo, @Nullable String str, @Nullable String str2, @Nullable Long l, @Nullable Long l2) {
        super(pathLogInfo, str, str2, l);
        this.fileCount = l2;
    }

    public FolderLogInfo(@Nonnull PathLogInfo pathLogInfo) {
        this(pathLogInfo, null, null, null, null);
    }

    @Override // com.dropbox.core.p013v2.teamlog.FileOrFolderLogInfo
    @Nonnull
    public PathLogInfo getPath() {
        return this.path;
    }

    @Override // com.dropbox.core.p013v2.teamlog.FileOrFolderLogInfo
    @Nullable
    public String getDisplayName() {
        return this.displayName;
    }

    @Override // com.dropbox.core.p013v2.teamlog.FileOrFolderLogInfo
    @Nullable
    public String getFileId() {
        return this.fileId;
    }

    @Override // com.dropbox.core.p013v2.teamlog.FileOrFolderLogInfo
    @Nullable
    public Long getFileSize() {
        return this.fileSize;
    }

    @Nullable
    public Long getFileCount() {
        return this.fileCount;
    }

    public static Builder newBuilder(PathLogInfo pathLogInfo) {
        return new Builder(pathLogInfo);
    }

    public static class Builder extends FileOrFolderLogInfo.Builder {
        protected Long fileCount;

        protected Builder(PathLogInfo pathLogInfo) {
            super(pathLogInfo);
            this.fileCount = null;
        }

        public Builder withFileCount(Long l) {
            this.fileCount = l;
            return this;
        }

        @Override // com.dropbox.core.v2.teamlog.FileOrFolderLogInfo.Builder
        public Builder withDisplayName(String str) {
            super.withDisplayName(str);
            return this;
        }

        @Override // com.dropbox.core.v2.teamlog.FileOrFolderLogInfo.Builder
        public Builder withFileId(String str) {
            super.withFileId(str);
            return this;
        }

        @Override // com.dropbox.core.v2.teamlog.FileOrFolderLogInfo.Builder
        public Builder withFileSize(Long l) {
            super.withFileSize(l);
            return this;
        }

        @Override // com.dropbox.core.v2.teamlog.FileOrFolderLogInfo.Builder
        public FolderLogInfo build() {
            return new FolderLogInfo(this.path, this.displayName, this.fileId, this.fileSize, this.fileCount);
        }
    }

    @Override // com.dropbox.core.p013v2.teamlog.FileOrFolderLogInfo
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.fileCount});
    }

    @Override // com.dropbox.core.p013v2.teamlog.FileOrFolderLogInfo
    public boolean equals(Object obj) {
        Long l;
        Long l2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        FolderLogInfo folderLogInfo = (FolderLogInfo) obj;
        return (this.path == folderLogInfo.path || this.path.equals(folderLogInfo.path)) && (this.displayName == folderLogInfo.displayName || (this.displayName != null && this.displayName.equals(folderLogInfo.displayName))) && ((this.fileId == folderLogInfo.fileId || (this.fileId != null && this.fileId.equals(folderLogInfo.fileId))) && ((this.fileSize == folderLogInfo.fileSize || (this.fileSize != null && this.fileSize.equals(folderLogInfo.fileSize))) && ((l = this.fileCount) == (l2 = folderLogInfo.fileCount) || (l != null && l.equals(l2)))));
    }

    @Override // com.dropbox.core.p013v2.teamlog.FileOrFolderLogInfo
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.teamlog.FileOrFolderLogInfo
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FolderLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FolderLogInfo folderLogInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
            PathLogInfo.Serializer.INSTANCE.serialize(folderLogInfo.path, jsonGenerator);
            if (folderLogInfo.displayName != null) {
                jsonGenerator.writeFieldName(Keys.DISPLAY_NAME);
                StoneSerializers.nullable(StoneSerializers.string()).serialize(folderLogInfo.displayName, jsonGenerator);
            }
            if (folderLogInfo.fileId != null) {
                jsonGenerator.writeFieldName(FontsContractCompat.Columns.FILE_ID);
                StoneSerializers.nullable(StoneSerializers.string()).serialize(folderLogInfo.fileId, jsonGenerator);
            }
            if (folderLogInfo.fileSize != null) {
                jsonGenerator.writeFieldName("file_size");
                StoneSerializers.nullable(StoneSerializers.uInt64()).serialize(folderLogInfo.fileSize, jsonGenerator);
            }
            if (folderLogInfo.fileCount != null) {
                jsonGenerator.writeFieldName("file_count");
                StoneSerializers.nullable(StoneSerializers.uInt64()).serialize(folderLogInfo.fileCount, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FolderLogInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                PathLogInfo pathLogInfoDeserialize = null;
                String str = null;
                String str2 = null;
                Long l = null;
                Long l2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (ClientCookie.PATH_ATTR.equals(currentName)) {
                        pathLogInfoDeserialize = PathLogInfo.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if (Keys.DISPLAY_NAME.equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if (FontsContractCompat.Columns.FILE_ID.equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("file_size".equals(currentName)) {
                        l = (Long) StoneSerializers.nullable(StoneSerializers.uInt64()).deserialize(jsonParser);
                    } else if ("file_count".equals(currentName)) {
                        l2 = (Long) StoneSerializers.nullable(StoneSerializers.uInt64()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (pathLogInfoDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"path\" missing.");
                }
                FolderLogInfo folderLogInfo = new FolderLogInfo(pathLogInfoDeserialize, str, str2, l, l2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(folderLogInfo, folderLogInfo.toStringMultiline());
                return folderLogInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
