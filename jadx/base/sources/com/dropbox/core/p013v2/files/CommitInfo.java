package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.fileproperties.PropertyGroup;
import com.dropbox.core.p013v2.files.WriteMode;
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
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public class CommitInfo {
    protected final boolean autorename;

    @Nullable
    protected final Date clientModified;

    @Nonnull
    protected final WriteMode mode;
    protected final boolean mute;

    @Nonnull
    protected final String path;

    @Nullable
    protected final List<PropertyGroup> propertyGroups;
    protected final boolean strictConflict;

    public CommitInfo(@Nonnull String str, @Nonnull WriteMode writeMode, boolean z, @Nullable Date date, boolean z2, @Nullable List<PropertyGroup> list, boolean z3) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!Pattern.matches("(/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)", str)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = str;
        if (writeMode == null) {
            throw new IllegalArgumentException("Required value for 'mode' is null");
        }
        this.mode = writeMode;
        this.autorename = z;
        this.clientModified = LangUtil.truncateMillis(date);
        this.mute = z2;
        if (list != null) {
            Iterator<PropertyGroup> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'propertyGroups' is null");
                }
            }
        }
        this.propertyGroups = list;
        this.strictConflict = z3;
    }

    public CommitInfo(@Nonnull String str) {
        this(str, WriteMode.ADD, false, null, false, null, false);
    }

    @Nonnull
    public String getPath() {
        return this.path;
    }

    @Nonnull
    public WriteMode getMode() {
        return this.mode;
    }

    public boolean getAutorename() {
        return this.autorename;
    }

    @Nullable
    public Date getClientModified() {
        return this.clientModified;
    }

    public boolean getMute() {
        return this.mute;
    }

    @Nullable
    public List<PropertyGroup> getPropertyGroups() {
        return this.propertyGroups;
    }

    public boolean getStrictConflict() {
        return this.strictConflict;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder {
        protected boolean autorename;
        protected Date clientModified;
        protected WriteMode mode;
        protected boolean mute;
        protected final String path;
        protected List<PropertyGroup> propertyGroups;
        protected boolean strictConflict;

        protected Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!Pattern.matches("(/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)", str)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.path = str;
            this.mode = WriteMode.ADD;
            this.autorename = false;
            this.clientModified = null;
            this.mute = false;
            this.propertyGroups = null;
            this.strictConflict = false;
        }

        public Builder withMode(WriteMode writeMode) {
            if (writeMode != null) {
                this.mode = writeMode;
                return this;
            }
            this.mode = WriteMode.ADD;
            return this;
        }

        public Builder withAutorename(Boolean bool) {
            if (bool != null) {
                this.autorename = bool.booleanValue();
                return this;
            }
            this.autorename = false;
            return this;
        }

        public Builder withClientModified(Date date) {
            this.clientModified = LangUtil.truncateMillis(date);
            return this;
        }

        public Builder withMute(Boolean bool) {
            if (bool != null) {
                this.mute = bool.booleanValue();
                return this;
            }
            this.mute = false;
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

        public Builder withStrictConflict(Boolean bool) {
            if (bool != null) {
                this.strictConflict = bool.booleanValue();
                return this;
            }
            this.strictConflict = false;
            return this;
        }

        public CommitInfo build() {
            return new CommitInfo(this.path, this.mode, this.autorename, this.clientModified, this.mute, this.propertyGroups, this.strictConflict);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.path, this.mode, Boolean.valueOf(this.autorename), this.clientModified, Boolean.valueOf(this.mute), this.propertyGroups, Boolean.valueOf(this.strictConflict)});
    }

    public boolean equals(Object obj) {
        CommitInfo commitInfo;
        String str;
        String str2;
        WriteMode writeMode;
        WriteMode writeMode2;
        Date date;
        Date date2;
        List<PropertyGroup> list;
        List<PropertyGroup> list2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.path) == (str2 = (commitInfo = (CommitInfo) obj).path) || str.equals(str2)) && (((writeMode = this.mode) == (writeMode2 = commitInfo.mode) || writeMode.equals(writeMode2)) && this.autorename == commitInfo.autorename && (((date = this.clientModified) == (date2 = commitInfo.clientModified) || (date != null && date.equals(date2))) && this.mute == commitInfo.mute && (((list = this.propertyGroups) == (list2 = commitInfo.propertyGroups) || (list != null && list.equals(list2))) && this.strictConflict == commitInfo.strictConflict)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<CommitInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(CommitInfo commitInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(ClientCookie.PATH_ATTR);
            StoneSerializers.string().serialize(commitInfo.path, jsonGenerator);
            jsonGenerator.writeFieldName("mode");
            WriteMode.Serializer.INSTANCE.serialize(commitInfo.mode, jsonGenerator);
            jsonGenerator.writeFieldName("autorename");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(commitInfo.autorename), jsonGenerator);
            if (commitInfo.clientModified != null) {
                jsonGenerator.writeFieldName("client_modified");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(commitInfo.clientModified, jsonGenerator);
            }
            jsonGenerator.writeFieldName("mute");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(commitInfo.mute), jsonGenerator);
            if (commitInfo.propertyGroups != null) {
                jsonGenerator.writeFieldName("property_groups");
                StoneSerializers.nullable(StoneSerializers.list(PropertyGroup.Serializer.INSTANCE)).serialize(commitInfo.propertyGroups, jsonGenerator);
            }
            jsonGenerator.writeFieldName("strict_conflict");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(commitInfo.strictConflict), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public CommitInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"path\" missing.");
                }
                CommitInfo commitInfo = new CommitInfo(strDeserialize, writeModeDeserialize, boolDeserialize.booleanValue(), date, boolDeserialize2.booleanValue(), list, boolDeserialize3.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(commitInfo, commitInfo.toStringMultiline());
                return commitInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
