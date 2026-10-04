package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.fileproperties.PropertyGroup;
import com.dropbox.core.p013v2.files.CommitInfo;
import com.dropbox.core.p013v2.files.WriteMode;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
class UploadArg extends CommitInfo {

    @Nullable
    protected final String contentHash;

    public UploadArg(@Nonnull String str, @Nonnull WriteMode writeMode, boolean z, @Nullable Date date, boolean z2, @Nullable List<PropertyGroup> list, boolean z3, @Nullable String str2) {
        super(str, writeMode, z, date, z2, list, z3);
        if (str2 != null) {
            if (str2.length() < 64) {
                throw new IllegalArgumentException("String 'contentHash' is shorter than 64");
            }
            if (str2.length() > 64) {
                throw new IllegalArgumentException("String 'contentHash' is longer than 64");
            }
        }
        this.contentHash = str2;
    }

    public UploadArg(@Nonnull String str) {
        this(str, WriteMode.ADD, false, null, false, null, false, null);
    }

    @Override // com.dropbox.core.p013v2.files.CommitInfo
    @Nonnull
    public String getPath() {
        return this.path;
    }

    @Override // com.dropbox.core.p013v2.files.CommitInfo
    @Nonnull
    public WriteMode getMode() {
        return this.mode;
    }

    @Override // com.dropbox.core.p013v2.files.CommitInfo
    public boolean getAutorename() {
        return this.autorename;
    }

    @Override // com.dropbox.core.p013v2.files.CommitInfo
    @Nullable
    public Date getClientModified() {
        return this.clientModified;
    }

    @Override // com.dropbox.core.p013v2.files.CommitInfo
    public boolean getMute() {
        return this.mute;
    }

    @Override // com.dropbox.core.p013v2.files.CommitInfo
    @Nullable
    public List<PropertyGroup> getPropertyGroups() {
        return this.propertyGroups;
    }

    @Override // com.dropbox.core.p013v2.files.CommitInfo
    public boolean getStrictConflict() {
        return this.strictConflict;
    }

    @Nullable
    public String getContentHash() {
        return this.contentHash;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder extends CommitInfo.Builder {
        protected String contentHash;

        @Override // com.dropbox.core.v2.files.CommitInfo.Builder
        public /* bridge */ /* synthetic */ CommitInfo.Builder withPropertyGroups(List list) {
            return withPropertyGroups((List<PropertyGroup>) list);
        }

        protected Builder(String str) {
            super(str);
            this.contentHash = null;
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

        @Override // com.dropbox.core.v2.files.CommitInfo.Builder
        public Builder withMode(WriteMode writeMode) {
            super.withMode(writeMode);
            return this;
        }

        @Override // com.dropbox.core.v2.files.CommitInfo.Builder
        public Builder withAutorename(Boolean bool) {
            super.withAutorename(bool);
            return this;
        }

        @Override // com.dropbox.core.v2.files.CommitInfo.Builder
        public Builder withClientModified(Date date) {
            super.withClientModified(date);
            return this;
        }

        @Override // com.dropbox.core.v2.files.CommitInfo.Builder
        public Builder withMute(Boolean bool) {
            super.withMute(bool);
            return this;
        }

        @Override // com.dropbox.core.v2.files.CommitInfo.Builder
        public Builder withPropertyGroups(List<PropertyGroup> list) {
            super.withPropertyGroups(list);
            return this;
        }

        @Override // com.dropbox.core.v2.files.CommitInfo.Builder
        public Builder withStrictConflict(Boolean bool) {
            super.withStrictConflict(bool);
            return this;
        }

        @Override // com.dropbox.core.v2.files.CommitInfo.Builder
        public UploadArg build() {
            return new UploadArg(this.path, this.mode, this.autorename, this.clientModified, this.mute, this.propertyGroups, this.strictConflict, this.contentHash);
        }
    }

    @Override // com.dropbox.core.p013v2.files.CommitInfo
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.contentHash});
    }

    @Override // com.dropbox.core.p013v2.files.CommitInfo
    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            UploadArg uploadArg = (UploadArg) obj;
            if ((this.path == uploadArg.path || this.path.equals(uploadArg.path)) && ((this.mode == uploadArg.mode || this.mode.equals(uploadArg.mode)) && this.autorename == uploadArg.autorename && ((this.clientModified == uploadArg.clientModified || (this.clientModified != null && this.clientModified.equals(uploadArg.clientModified))) && this.mute == uploadArg.mute && ((this.propertyGroups == uploadArg.propertyGroups || (this.propertyGroups != null && this.propertyGroups.equals(uploadArg.propertyGroups))) && this.strictConflict == uploadArg.strictConflict && ((str = this.contentHash) == (str2 = uploadArg.contentHash) || (str != null && str.equals(str2))))))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.dropbox.core.p013v2.files.CommitInfo
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.files.CommitInfo
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<UploadArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(UploadArg uploadArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
            StoneSerializers.string().serialize(uploadArg.path, jsonGenerator);
            jsonGenerator.writeFieldName("mode");
            WriteMode.Serializer.INSTANCE.serialize(uploadArg.mode, jsonGenerator);
            jsonGenerator.writeFieldName("autorename");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(uploadArg.autorename), jsonGenerator);
            if (uploadArg.clientModified != null) {
                jsonGenerator.writeFieldName("client_modified");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(uploadArg.clientModified, jsonGenerator);
            }
            jsonGenerator.writeFieldName("mute");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(uploadArg.mute), jsonGenerator);
            if (uploadArg.propertyGroups != null) {
                jsonGenerator.writeFieldName("property_groups");
                StoneSerializers.nullable(StoneSerializers.list(PropertyGroup.Serializer.INSTANCE)).serialize(uploadArg.propertyGroups, jsonGenerator);
            }
            jsonGenerator.writeFieldName("strict_conflict");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(uploadArg.strictConflict), jsonGenerator);
            if (uploadArg.contentHash != null) {
                jsonGenerator.writeFieldName("content_hash");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(uploadArg.contentHash, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public UploadArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize = false;
                Boolean boolDeserialize2 = false;
                Boolean boolDeserialize3 = false;
                String strDeserialize = null;
                Date date = null;
                List list = null;
                String str = null;
                WriteMode writeModeDeserialize = WriteMode.ADD;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (ClientCookie.PATH_ATTR.equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("mode".equals(currentName)) {
                        writeModeDeserialize = WriteMode.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("autorename".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("client_modified".equals(currentName)) {
                        date = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else if ("mute".equals(currentName)) {
                        boolDeserialize2 = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("property_groups".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(PropertyGroup.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else if ("strict_conflict".equals(currentName)) {
                        boolDeserialize3 = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("content_hash".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"path\" missing.");
                }
                UploadArg uploadArg = new UploadArg(strDeserialize, writeModeDeserialize, boolDeserialize.booleanValue(), date, boolDeserialize2.booleanValue(), list, boolDeserialize3.booleanValue(), str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(uploadArg, uploadArg.toStringMultiline());
                return uploadArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
