package com.dropbox.core.p013v2.files;

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
public class FileSharingInfo extends SharingInfo {

    @Nullable
    protected final String modifiedBy;

    @Nonnull
    protected final String parentSharedFolderId;

    public FileSharingInfo(boolean z, @Nonnull String str, @Nullable String str2) {
        super(z);
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'parentSharedFolderId' is null");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z:]+", str)) {
            throw new IllegalArgumentException("String 'parentSharedFolderId' does not match pattern");
        }
        this.parentSharedFolderId = str;
        if (str2 != null) {
            if (str2.length() < 40) {
                throw new IllegalArgumentException("String 'modifiedBy' is shorter than 40");
            }
            if (str2.length() > 40) {
                throw new IllegalArgumentException("String 'modifiedBy' is longer than 40");
            }
        }
        this.modifiedBy = str2;
    }

    public FileSharingInfo(boolean z, @Nonnull String str) {
        this(z, str, null);
    }

    @Override // com.dropbox.core.p013v2.files.SharingInfo
    public boolean getReadOnly() {
        return this.readOnly;
    }

    @Nonnull
    public String getParentSharedFolderId() {
        return this.parentSharedFolderId;
    }

    @Nullable
    public String getModifiedBy() {
        return this.modifiedBy;
    }

    @Override // com.dropbox.core.p013v2.files.SharingInfo
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.parentSharedFolderId, this.modifiedBy});
    }

    @Override // com.dropbox.core.p013v2.files.SharingInfo
    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            FileSharingInfo fileSharingInfo = (FileSharingInfo) obj;
            if (this.readOnly == fileSharingInfo.readOnly && (((str = this.parentSharedFolderId) == (str2 = fileSharingInfo.parentSharedFolderId) || str.equals(str2)) && ((str3 = this.modifiedBy) == (str4 = fileSharingInfo.modifiedBy) || (str3 != null && str3.equals(str4))))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.dropbox.core.p013v2.files.SharingInfo
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.files.SharingInfo
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FileSharingInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FileSharingInfo fileSharingInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("read_only");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(fileSharingInfo.readOnly), jsonGenerator);
            jsonGenerator.writeFieldName("parent_shared_folder_id");
            StoneSerializers.string().serialize(fileSharingInfo.parentSharedFolderId, jsonGenerator);
            if (fileSharingInfo.modifiedBy != null) {
                jsonGenerator.writeFieldName("modified_by");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(fileSharingInfo.modifiedBy, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FileSharingInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Boolean boolDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                String str = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("read_only".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("parent_shared_folder_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("modified_by".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"read_only\" missing.");
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"parent_shared_folder_id\" missing.");
                }
                FileSharingInfo fileSharingInfo = new FileSharingInfo(boolDeserialize.booleanValue(), strDeserialize, str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(fileSharingInfo, fileSharingInfo.toStringMultiline());
                return fileSharingInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
