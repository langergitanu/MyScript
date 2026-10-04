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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class FolderSharingInfo extends SharingInfo {
    protected final boolean noAccess;

    @Nullable
    protected final String parentSharedFolderId;

    @Nullable
    protected final String sharedFolderId;
    protected final boolean traverseOnly;

    public FolderSharingInfo(boolean z, @Nullable String str, @Nullable String str2, boolean z2, boolean z3) {
        super(z);
        if (str != null && !Pattern.matches("[-_0-9a-zA-Z:]+", str)) {
            throw new IllegalArgumentException("String 'parentSharedFolderId' does not match pattern");
        }
        this.parentSharedFolderId = str;
        if (str2 != null && !Pattern.matches("[-_0-9a-zA-Z:]+", str2)) {
            throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
        }
        this.sharedFolderId = str2;
        this.traverseOnly = z2;
        this.noAccess = z3;
    }

    public FolderSharingInfo(boolean z) {
        this(z, null, null, false, false);
    }

    @Override // com.dropbox.core.p013v2.files.SharingInfo
    public boolean getReadOnly() {
        return this.readOnly;
    }

    @Nullable
    public String getParentSharedFolderId() {
        return this.parentSharedFolderId;
    }

    @Nullable
    public String getSharedFolderId() {
        return this.sharedFolderId;
    }

    public boolean getTraverseOnly() {
        return this.traverseOnly;
    }

    public boolean getNoAccess() {
        return this.noAccess;
    }

    public static Builder newBuilder(boolean z) {
        return new Builder(z);
    }

    public static class Builder {
        protected final boolean readOnly;
        protected String parentSharedFolderId = null;
        protected String sharedFolderId = null;
        protected boolean traverseOnly = false;
        protected boolean noAccess = false;

        protected Builder(boolean z) {
            this.readOnly = z;
        }

        public Builder withParentSharedFolderId(String str) {
            if (str != null && !Pattern.matches("[-_0-9a-zA-Z:]+", str)) {
                throw new IllegalArgumentException("String 'parentSharedFolderId' does not match pattern");
            }
            this.parentSharedFolderId = str;
            return this;
        }

        public Builder withSharedFolderId(String str) {
            if (str != null && !Pattern.matches("[-_0-9a-zA-Z:]+", str)) {
                throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
            }
            this.sharedFolderId = str;
            return this;
        }

        public Builder withTraverseOnly(Boolean bool) {
            if (bool != null) {
                this.traverseOnly = bool.booleanValue();
                return this;
            }
            this.traverseOnly = false;
            return this;
        }

        public Builder withNoAccess(Boolean bool) {
            if (bool != null) {
                this.noAccess = bool.booleanValue();
                return this;
            }
            this.noAccess = false;
            return this;
        }

        public FolderSharingInfo build() {
            return new FolderSharingInfo(this.readOnly, this.parentSharedFolderId, this.sharedFolderId, this.traverseOnly, this.noAccess);
        }
    }

    @Override // com.dropbox.core.p013v2.files.SharingInfo
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.parentSharedFolderId, this.sharedFolderId, Boolean.valueOf(this.traverseOnly), Boolean.valueOf(this.noAccess)});
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
            FolderSharingInfo folderSharingInfo = (FolderSharingInfo) obj;
            if (this.readOnly == folderSharingInfo.readOnly && (((str = this.parentSharedFolderId) == (str2 = folderSharingInfo.parentSharedFolderId) || (str != null && str.equals(str2))) && (((str3 = this.sharedFolderId) == (str4 = folderSharingInfo.sharedFolderId) || (str3 != null && str3.equals(str4))) && this.traverseOnly == folderSharingInfo.traverseOnly && this.noAccess == folderSharingInfo.noAccess))) {
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

    static class Serializer extends StructSerializer<FolderSharingInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FolderSharingInfo folderSharingInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("read_only");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(folderSharingInfo.readOnly), jsonGenerator);
            if (folderSharingInfo.parentSharedFolderId != null) {
                jsonGenerator.writeFieldName("parent_shared_folder_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(folderSharingInfo.parentSharedFolderId, jsonGenerator);
            }
            if (folderSharingInfo.sharedFolderId != null) {
                jsonGenerator.writeFieldName("shared_folder_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(folderSharingInfo.sharedFolderId, jsonGenerator);
            }
            jsonGenerator.writeFieldName("traverse_only");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(folderSharingInfo.traverseOnly), jsonGenerator);
            jsonGenerator.writeFieldName("no_access");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(folderSharingInfo.noAccess), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FolderSharingInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Boolean boolDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize2 = false;
                Boolean boolDeserialize3 = false;
                String str = null;
                String str2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("read_only".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("parent_shared_folder_id".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("shared_folder_id".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("traverse_only".equals(currentName)) {
                        boolDeserialize2 = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("no_access".equals(currentName)) {
                        boolDeserialize3 = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"read_only\" missing.");
                }
                FolderSharingInfo folderSharingInfo = new FolderSharingInfo(boolDeserialize.booleanValue(), str, str2, boolDeserialize2.booleanValue(), boolDeserialize3.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(folderSharingInfo, folderSharingInfo.toStringMultiline());
                return folderSharingInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
