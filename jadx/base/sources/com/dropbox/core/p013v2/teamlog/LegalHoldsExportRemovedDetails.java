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

/* JADX INFO: loaded from: classes5.dex */
public class LegalHoldsExportRemovedDetails {

    @Nonnull
    protected final String exportName;

    @Nonnull
    protected final String legalHoldId;

    @Nonnull
    protected final String name;

    public LegalHoldsExportRemovedDetails(@Nonnull String str, @Nonnull String str2, @Nonnull String str3) {
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
        LegalHoldsExportRemovedDetails legalHoldsExportRemovedDetails = (LegalHoldsExportRemovedDetails) obj;
        String str5 = this.legalHoldId;
        String str6 = legalHoldsExportRemovedDetails.legalHoldId;
        return (str5 == str6 || str5.equals(str6)) && ((str = this.name) == (str2 = legalHoldsExportRemovedDetails.name) || str.equals(str2)) && ((str3 = this.exportName) == (str4 = legalHoldsExportRemovedDetails.exportName) || str3.equals(str4));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<LegalHoldsExportRemovedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(LegalHoldsExportRemovedDetails legalHoldsExportRemovedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("legal_hold_id");
            StoneSerializers.string().serialize(legalHoldsExportRemovedDetails.legalHoldId, jsonGenerator);
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(legalHoldsExportRemovedDetails.name, jsonGenerator);
            jsonGenerator.writeFieldName("export_name");
            StoneSerializers.string().serialize(legalHoldsExportRemovedDetails.exportName, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public LegalHoldsExportRemovedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                String strDeserialize3 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("legal_hold_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("name".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("export_name".equals(currentName)) {
                        strDeserialize3 = StoneSerializers.string().deserialize(jsonParser);
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
                LegalHoldsExportRemovedDetails legalHoldsExportRemovedDetails = new LegalHoldsExportRemovedDetails(strDeserialize, strDeserialize2, strDeserialize3);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(legalHoldsExportRemovedDetails, legalHoldsExportRemovedDetails.toStringMultiline());
                return legalHoldsExportRemovedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
