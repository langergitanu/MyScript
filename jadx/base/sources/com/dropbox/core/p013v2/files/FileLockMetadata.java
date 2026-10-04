package com.dropbox.core.p013v2.files;

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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class FileLockMetadata {

    @Nullable
    protected final Date created;

    @Nullable
    protected final Boolean isLockholder;

    @Nullable
    protected final String lockholderAccountId;

    @Nullable
    protected final String lockholderName;

    public FileLockMetadata(@Nullable Boolean bool, @Nullable String str, @Nullable String str2, @Nullable Date date) {
        this.isLockholder = bool;
        this.lockholderName = str;
        if (str2 != null) {
            if (str2.length() < 40) {
                throw new IllegalArgumentException("String 'lockholderAccountId' is shorter than 40");
            }
            if (str2.length() > 40) {
                throw new IllegalArgumentException("String 'lockholderAccountId' is longer than 40");
            }
        }
        this.lockholderAccountId = str2;
        this.created = LangUtil.truncateMillis(date);
    }

    public FileLockMetadata() {
        this(null, null, null, null);
    }

    @Nullable
    public Boolean getIsLockholder() {
        return this.isLockholder;
    }

    @Nullable
    public String getLockholderName() {
        return this.lockholderName;
    }

    @Nullable
    public String getLockholderAccountId() {
        return this.lockholderAccountId;
    }

    @Nullable
    public Date getCreated() {
        return this.created;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected Boolean isLockholder = null;
        protected String lockholderName = null;
        protected String lockholderAccountId = null;
        protected Date created = null;

        protected Builder() {
        }

        public Builder withIsLockholder(Boolean bool) {
            this.isLockholder = bool;
            return this;
        }

        public Builder withLockholderName(String str) {
            this.lockholderName = str;
            return this;
        }

        public Builder withLockholderAccountId(String str) {
            if (str != null) {
                if (str.length() < 40) {
                    throw new IllegalArgumentException("String 'lockholderAccountId' is shorter than 40");
                }
                if (str.length() > 40) {
                    throw new IllegalArgumentException("String 'lockholderAccountId' is longer than 40");
                }
            }
            this.lockholderAccountId = str;
            return this;
        }

        public Builder withCreated(Date date) {
            this.created = LangUtil.truncateMillis(date);
            return this;
        }

        public FileLockMetadata build() {
            return new FileLockMetadata(this.isLockholder, this.lockholderName, this.lockholderAccountId, this.created);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.isLockholder, this.lockholderName, this.lockholderAccountId, this.created});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        Date date;
        Date date2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        FileLockMetadata fileLockMetadata = (FileLockMetadata) obj;
        Boolean bool = this.isLockholder;
        Boolean bool2 = fileLockMetadata.isLockholder;
        return (bool == bool2 || (bool != null && bool.equals(bool2))) && ((str = this.lockholderName) == (str2 = fileLockMetadata.lockholderName) || (str != null && str.equals(str2))) && (((str3 = this.lockholderAccountId) == (str4 = fileLockMetadata.lockholderAccountId) || (str3 != null && str3.equals(str4))) && ((date = this.created) == (date2 = fileLockMetadata.created) || (date != null && date.equals(date2))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FileLockMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FileLockMetadata fileLockMetadata, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (fileLockMetadata.isLockholder != null) {
                jsonGenerator.writeFieldName("is_lockholder");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(fileLockMetadata.isLockholder, jsonGenerator);
            }
            if (fileLockMetadata.lockholderName != null) {
                jsonGenerator.writeFieldName("lockholder_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(fileLockMetadata.lockholderName, jsonGenerator);
            }
            if (fileLockMetadata.lockholderAccountId != null) {
                jsonGenerator.writeFieldName("lockholder_account_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(fileLockMetadata.lockholderAccountId, jsonGenerator);
            }
            if (fileLockMetadata.created != null) {
                jsonGenerator.writeFieldName("created");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(fileLockMetadata.created, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FileLockMetadata deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Boolean bool = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String str = null;
                String str2 = null;
                Date date = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("is_lockholder".equals(currentName)) {
                        bool = (Boolean) StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(jsonParser);
                    } else if ("lockholder_name".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("lockholder_account_id".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("created".equals(currentName)) {
                        date = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                FileLockMetadata fileLockMetadata = new FileLockMetadata(bool, str, str2, date);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(fileLockMetadata, fileLockMetadata.toStringMultiline());
                return fileLockMetadata;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
