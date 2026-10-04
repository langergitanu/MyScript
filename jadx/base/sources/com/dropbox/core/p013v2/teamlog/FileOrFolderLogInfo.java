package com.dropbox.core.p013v2.teamlog;

import androidx.core.provider.FontsContractCompat;
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
public class FileOrFolderLogInfo {

    @Nullable
    protected final String displayName;

    @Nullable
    protected final String fileId;

    @Nullable
    protected final Long fileSize;

    @Nonnull
    protected final PathLogInfo path;

    public FileOrFolderLogInfo(@Nonnull PathLogInfo pathLogInfo, @Nullable String str, @Nullable String str2, @Nullable Long l) {
        if (pathLogInfo == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        this.path = pathLogInfo;
        this.displayName = str;
        this.fileId = str2;
        this.fileSize = l;
    }

    public FileOrFolderLogInfo(@Nonnull PathLogInfo pathLogInfo) {
        this(pathLogInfo, null, null, null);
    }

    @Nonnull
    public PathLogInfo getPath() {
        return this.path;
    }

    @Nullable
    public String getDisplayName() {
        return this.displayName;
    }

    @Nullable
    public String getFileId() {
        return this.fileId;
    }

    @Nullable
    public Long getFileSize() {
        return this.fileSize;
    }

    public static Builder newBuilder(PathLogInfo pathLogInfo) {
        return new Builder(pathLogInfo);
    }

    public static class Builder {
        protected String displayName;
        protected String fileId;
        protected Long fileSize;
        protected final PathLogInfo path;

        protected Builder(PathLogInfo pathLogInfo) {
            if (pathLogInfo == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            this.path = pathLogInfo;
            this.displayName = null;
            this.fileId = null;
            this.fileSize = null;
        }

        public Builder withDisplayName(String str) {
            this.displayName = str;
            return this;
        }

        public Builder withFileId(String str) {
            this.fileId = str;
            return this;
        }

        public Builder withFileSize(Long l) {
            this.fileSize = l;
            return this;
        }

        public FileOrFolderLogInfo build() {
            return new FileOrFolderLogInfo(this.path, this.displayName, this.fileId, this.fileSize);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.path, this.displayName, this.fileId, this.fileSize});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        Long l;
        Long l2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        FileOrFolderLogInfo fileOrFolderLogInfo = (FileOrFolderLogInfo) obj;
        PathLogInfo pathLogInfo = this.path;
        PathLogInfo pathLogInfo2 = fileOrFolderLogInfo.path;
        return (pathLogInfo == pathLogInfo2 || pathLogInfo.equals(pathLogInfo2)) && ((str = this.displayName) == (str2 = fileOrFolderLogInfo.displayName) || (str != null && str.equals(str2))) && (((str3 = this.fileId) == (str4 = fileOrFolderLogInfo.fileId) || (str3 != null && str3.equals(str4))) && ((l = this.fileSize) == (l2 = fileOrFolderLogInfo.fileSize) || (l != null && l.equals(l2))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    private static class Serializer extends StructSerializer<FileOrFolderLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        private Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FileOrFolderLogInfo fileOrFolderLogInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
            PathLogInfo.Serializer.INSTANCE.serialize(fileOrFolderLogInfo.path, jsonGenerator);
            if (fileOrFolderLogInfo.displayName != null) {
                jsonGenerator.writeFieldName(Keys.DISPLAY_NAME);
                StoneSerializers.nullable(StoneSerializers.string()).serialize(fileOrFolderLogInfo.displayName, jsonGenerator);
            }
            if (fileOrFolderLogInfo.fileId != null) {
                jsonGenerator.writeFieldName(FontsContractCompat.Columns.FILE_ID);
                StoneSerializers.nullable(StoneSerializers.string()).serialize(fileOrFolderLogInfo.fileId, jsonGenerator);
            }
            if (fileOrFolderLogInfo.fileSize != null) {
                jsonGenerator.writeFieldName("file_size");
                StoneSerializers.nullable(StoneSerializers.uInt64()).serialize(fileOrFolderLogInfo.fileSize, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FileOrFolderLogInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                FileOrFolderLogInfo fileOrFolderLogInfo = new FileOrFolderLogInfo(pathLogInfoDeserialize, str, str2, l);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(fileOrFolderLogInfo, fileOrFolderLogInfo.toStringMultiline());
                return fileOrFolderLogInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
