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
public class LegalHoldsExportAHoldDetails {

    @Nullable
    protected final String exportName;

    @Nonnull
    protected final String legalHoldId;

    @Nonnull
    protected final String name;

    public LegalHoldsExportAHoldDetails(@Nonnull String str, @Nonnull String str2, @Nullable String str3) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'legalHoldId' is null");
        }
        this.legalHoldId = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = str2;
        this.exportName = str3;
    }

    public LegalHoldsExportAHoldDetails(@Nonnull String str, @Nonnull String str2) {
        this(str, str2, null);
    }

    @Nonnull
    public String getLegalHoldId() {
        return this.legalHoldId;
    }

    @Nonnull
    public String getName() {
        return this.name;
    }

    @Nullable
    public String getExportName() {
        return this.exportName;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.legalHoldId, this.name, this.exportName});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        LegalHoldsExportAHoldDetails legalHoldsExportAHoldDetails = (LegalHoldsExportAHoldDetails) obj;
        String str5 = this.legalHoldId;
        String str6 = legalHoldsExportAHoldDetails.legalHoldId;
        return (str5 == str6 || str5.equals(str6)) && ((str = this.name) == (str2 = legalHoldsExportAHoldDetails.name) || str.equals(str2)) && ((str3 = this.exportName) == (str4 = legalHoldsExportAHoldDetails.exportName) || (str3 != null && str3.equals(str4)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<LegalHoldsExportAHoldDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(LegalHoldsExportAHoldDetails legalHoldsExportAHoldDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("legal_hold_id");
            StoneSerializers.string().serialize(legalHoldsExportAHoldDetails.legalHoldId, jsonGenerator);
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(legalHoldsExportAHoldDetails.name, jsonGenerator);
            if (legalHoldsExportAHoldDetails.exportName != null) {
                jsonGenerator.writeFieldName("export_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(legalHoldsExportAHoldDetails.exportName, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public LegalHoldsExportAHoldDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize2 = null;
                String str = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("legal_hold_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("name".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("export_name".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
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
                LegalHoldsExportAHoldDetails legalHoldsExportAHoldDetails = new LegalHoldsExportAHoldDetails(strDeserialize, strDeserialize2, str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(legalHoldsExportAHoldDetails, legalHoldsExportAHoldDetails.toStringMultiline());
                return legalHoldsExportAHoldDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
