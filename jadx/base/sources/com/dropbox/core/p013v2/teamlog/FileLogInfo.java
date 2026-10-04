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
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes5.dex */
public class FileLogInfo extends FileOrFolderLogInfo {
    public FileLogInfo(@Nonnull PathLogInfo pathLogInfo, @Nullable String str, @Nullable String str2, @Nullable Long l) {
        super(pathLogInfo, str, str2, l);
    }

    public FileLogInfo(@Nonnull PathLogInfo pathLogInfo) {
        this(pathLogInfo, null, null, null);
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

    public static Builder newBuilder(PathLogInfo pathLogInfo) {
        return new Builder(pathLogInfo);
    }

    public static class Builder extends FileOrFolderLogInfo.Builder {
        protected Builder(PathLogInfo pathLogInfo) {
            super(pathLogInfo);
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
        public FileLogInfo build() {
            return new FileLogInfo(this.path, this.displayName, this.fileId, this.fileSize);
        }
    }

    @Override // com.dropbox.core.p013v2.teamlog.FileOrFolderLogInfo
    public int hashCode() {
        return getClass().toString().hashCode();
    }

    @Override // com.dropbox.core.p013v2.teamlog.FileOrFolderLogInfo
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        FileLogInfo fileLogInfo = (FileLogInfo) obj;
        return (this.path == fileLogInfo.path || this.path.equals(fileLogInfo.path)) && (this.displayName == fileLogInfo.displayName || (this.displayName != null && this.displayName.equals(fileLogInfo.displayName))) && ((this.fileId == fileLogInfo.fileId || (this.fileId != null && this.fileId.equals(fileLogInfo.fileId))) && (this.fileSize == fileLogInfo.fileSize || (this.fileSize != null && this.fileSize.equals(fileLogInfo.fileSize))));
    }

    @Override // com.dropbox.core.p013v2.teamlog.FileOrFolderLogInfo
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.teamlog.FileOrFolderLogInfo
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FileLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FileLogInfo fileLogInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
            PathLogInfo.Serializer.INSTANCE.serialize(fileLogInfo.path, jsonGenerator);
            if (fileLogInfo.displayName != null) {
                jsonGenerator.writeFieldName(Keys.DISPLAY_NAME);
                StoneSerializers.nullable(StoneSerializers.string()).serialize(fileLogInfo.displayName, jsonGenerator);
            }
            if (fileLogInfo.fileId != null) {
                jsonGenerator.writeFieldName(FontsContractCompat.Columns.FILE_ID);
                StoneSerializers.nullable(StoneSerializers.string()).serialize(fileLogInfo.fileId, jsonGenerator);
            }
            if (fileLogInfo.fileSize != null) {
                jsonGenerator.writeFieldName("file_size");
                StoneSerializers.nullable(StoneSerializers.uInt64()).serialize(fileLogInfo.fileSize, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FileLogInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            PathLogInfo pathLogInfoDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String str = null;
                String str2 = null;
                Long l = null;
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
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (pathLogInfoDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"path\" missing.");
                }
                FileLogInfo fileLogInfo = new FileLogInfo(pathLogInfoDeserialize, str, str2, l);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(fileLogInfo, fileLogInfo.toStringMultiline());
                return fileLogInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
