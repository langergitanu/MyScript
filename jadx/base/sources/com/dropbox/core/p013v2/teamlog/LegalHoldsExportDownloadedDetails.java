package com.dropbox.core.p013v2.teamlog;

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

/* JADX INFO: loaded from: classes5.dex */
public class LegalHoldsExportDownloadedDetails {

    @Nonnull
    protected final String exportName;

    @Nullable
    protected final String fileName;

    @Nonnull
    protected final String legalHoldId;

    @Nonnull
    protected final String name;

    @Nullable
    protected final String part;

    public LegalHoldsExportDownloadedDetails(@Nonnull String str, @Nonnull String str2, @Nonnull String str3, @Nullable String str4, @Nullable String str5) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'legalHoldId' is null");
        }
        this.legalHoldId = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = str2;
        if (str3 == null) {
            throw new IllegalArgumentException("Required value for 'exportName' is null");
        }
        this.exportName = str3;
        this.part = str4;
        this.fileName = str5;
    }

    public LegalHoldsExportDownloadedDetails(@Nonnull String str, @Nonnull String str2, @Nonnull String str3) {
        this(str, str2, str3, null, null);
    }

    @Nonnull
    public String getLegalHoldId() {
        return this.legalHoldId;
    }

    @Nonnull
    public String getName() {
        return this.name;
    }

    @Nonnull
    public String getExportName() {
        return this.exportName;
    }

    @Nullable
    public String getPart() {
        return this.part;
    }

    @Nullable
    public String getFileName() {
        return this.fileName;
    }

    public static Builder newBuilder(String str, String str2, String str3) {
        return new Builder(str, str2, str3);
    }

    public static class Builder {
        protected final String exportName;
        protected String fileName;
        protected final String legalHoldId;
        protected final String name;
        protected String part;

        protected Builder(String str, String str2, String str3) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'legalHoldId' is null");
            }
            this.legalHoldId = str;
            if (str2 == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.name = str2;
            if (str3 == null) {
                throw new IllegalArgumentException("Required value for 'exportName' is null");
            }
            this.exportName = str3;
            this.part = null;
            this.fileName = null;
        }

        public Builder withPart(String str) {
            this.part = str;
            return this;
        }

        public Builder withFileName(String str) {
            this.fileName = str;
            return this;
        }

        public LegalHoldsExportDownloadedDetails build() {
            return new LegalHoldsExportDownloadedDetails(this.legalHoldId, this.name, this.exportName, this.part, this.fileName);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.legalHoldId, this.name, this.exportName, this.part, this.fileName});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        LegalHoldsExportDownloadedDetails legalHoldsExportDownloadedDetails = (LegalHoldsExportDownloadedDetails) obj;
        String str9 = this.legalHoldId;
        String str10 = legalHoldsExportDownloadedDetails.legalHoldId;
        return (str9 == str10 || str9.equals(str10)) && ((str = this.name) == (str2 = legalHoldsExportDownloadedDetails.name) || str.equals(str2)) && (((str3 = this.exportName) == (str4 = legalHoldsExportDownloadedDetails.exportName) || str3.equals(str4)) && (((str5 = this.part) == (str6 = legalHoldsExportDownloadedDetails.part) || (str5 != null && str5.equals(str6))) && ((str7 = this.fileName) == (str8 = legalHoldsExportDownloadedDetails.fileName) || (str7 != null && str7.equals(str8)))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<LegalHoldsExportDownloadedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(LegalHoldsExportDownloadedDetails legalHoldsExportDownloadedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("legal_hold_id");
            StoneSerializers.string().serialize(legalHoldsExportDownloadedDetails.legalHoldId, jsonGenerator);
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(legalHoldsExportDownloadedDetails.name, jsonGenerator);
            jsonGenerator.writeFieldName("export_name");
            StoneSerializers.string().serialize(legalHoldsExportDownloadedDetails.exportName, jsonGenerator);
            if (legalHoldsExportDownloadedDetails.part != null) {
                jsonGenerator.writeFieldName("part");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(legalHoldsExportDownloadedDetails.part, jsonGenerator);
            }
            if (legalHoldsExportDownloadedDetails.fileName != null) {
                jsonGenerator.writeFieldName("file_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(legalHoldsExportDownloadedDetails.fileName, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public LegalHoldsExportDownloadedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                String strDeserialize2 = null;
                String strDeserialize3 = null;
                String str = null;
                String str2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("legal_hold_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("name".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("export_name".equals(currentName)) {
                        strDeserialize3 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("part".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("file_name".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"legal_hold_id\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"name\" missing.");
                }
                if (strDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"export_name\" missing.");
                }
                LegalHoldsExportDownloadedDetails legalHoldsExportDownloadedDetails = new LegalHoldsExportDownloadedDetails(strDeserialize, strDeserialize2, strDeserialize3, str, str2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(legalHoldsExportDownloadedDetails, legalHoldsExportDownloadedDetails.toStringMultiline());
                return legalHoldsExportDownloadedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
