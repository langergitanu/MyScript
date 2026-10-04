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
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class ExportMetadata {

    @Nullable
    protected final String exportHash;

    @Nonnull
    protected final String name;

    @Nullable
    protected final Long paperRevision;
    protected final long size;

    public ExportMetadata(@Nonnull String str, long j, @Nullable String str2, @Nullable Long l) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = str;
        this.size = j;
        if (str2 != null) {
            if (str2.length() < 64) {
                throw new IllegalArgumentException("String 'exportHash' is shorter than 64");
            }
            if (str2.length() > 64) {
                throw new IllegalArgumentException("String 'exportHash' is longer than 64");
            }
        }
        this.exportHash = str2;
        this.paperRevision = l;
    }

    public ExportMetadata(@Nonnull String str, long j) {
        this(str, j, null, null);
    }

    @Nonnull
    public String getName() {
        return this.name;
    }

    public long getSize() {
        return this.size;
    }

    @Nullable
    public String getExportHash() {
        return this.exportHash;
    }

    @Nullable
    public Long getPaperRevision() {
        return this.paperRevision;
    }

    public static Builder newBuilder(String str, long j) {
        return new Builder(str, j);
    }

    public static class Builder {
        protected String exportHash;
        protected final String name;
        protected Long paperRevision;
        protected final long size;

        protected Builder(String str, long j) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.name = str;
            this.size = j;
            this.exportHash = null;
            this.paperRevision = null;
        }

        public Builder withExportHash(String str) {
            if (str != null) {
                if (str.length() < 64) {
                    throw new IllegalArgumentException("String 'exportHash' is shorter than 64");
                }
                if (str.length() > 64) {
                    throw new IllegalArgumentException("String 'exportHash' is longer than 64");
                }
            }
            this.exportHash = str;
            return this;
        }

        public Builder withPaperRevision(Long l) {
            this.paperRevision = l;
            return this;
        }

        public ExportMetadata build() {
            return new ExportMetadata(this.name, this.size, this.exportHash, this.paperRevision);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.name, Long.valueOf(this.size), this.exportHash, this.paperRevision});
    }

    public boolean equals(Object obj) {
        ExportMetadata exportMetadata;
        String str;
        String str2;
        String str3;
        String str4;
        Long l;
        Long l2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.name) == (str2 = (exportMetadata = (ExportMetadata) obj).name) || str.equals(str2)) && this.size == exportMetadata.size && (((str3 = this.exportHash) == (str4 = exportMetadata.exportHash) || (str3 != null && str3.equals(str4))) && ((l = this.paperRevision) == (l2 = exportMetadata.paperRevision) || (l != null && l.equals(l2))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ExportMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ExportMetadata exportMetadata, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(exportMetadata.name, jsonGenerator);
            jsonGenerator.writeFieldName("size");
            StoneSerializers.uInt64().serialize(Long.valueOf(exportMetadata.size), jsonGenerator);
            if (exportMetadata.exportHash != null) {
                jsonGenerator.writeFieldName("export_hash");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(exportMetadata.exportHash, jsonGenerator);
            }
            if (exportMetadata.paperRevision != null) {
                jsonGenerator.writeFieldName("paper_revision");
                StoneSerializers.nullable(StoneSerializers.int64()).serialize(exportMetadata.paperRevision, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ExportMetadata deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Long lDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                String str = null;
                Long l = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("size".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else if ("export_hash".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("paper_revision".equals(currentName)) {
                        l = (Long) StoneSerializers.nullable(StoneSerializers.int64()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"name\" missing.");
                }
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"size\" missing.");
                }
                ExportMetadata exportMetadata = new ExportMetadata(strDeserialize, lDeserialize.longValue(), str, l);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(exportMetadata, exportMetadata.toStringMultiline());
                return exportMetadata;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
