package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class InsufficientQuotaAmounts {
    protected final long spaceLeft;
    protected final long spaceNeeded;
    protected final long spaceShortage;

    public InsufficientQuotaAmounts(long j, long j2, long j3) {
        this.spaceNeeded = j;
        this.spaceShortage = j2;
        this.spaceLeft = j3;
    }

    public long getSpaceNeeded() {
        return this.spaceNeeded;
    }

    public long getSpaceShortage() {
        return this.spaceShortage;
    }

    public long getSpaceLeft() {
        return this.spaceLeft;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.spaceNeeded), Long.valueOf(this.spaceShortage), Long.valueOf(this.spaceLeft)});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            InsufficientQuotaAmounts insufficientQuotaAmounts = (InsufficientQuotaAmounts) obj;
            if (this.spaceNeeded == insufficientQuotaAmounts.spaceNeeded && this.spaceShortage == insufficientQuotaAmounts.spaceShortage && this.spaceLeft == insufficientQuotaAmounts.spaceLeft) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<InsufficientQuotaAmounts> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(InsufficientQuotaAmounts insufficientQuotaAmounts, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("space_needed");
            StoneSerializers.uInt64().serialize(Long.valueOf(insufficientQuotaAmounts.spaceNeeded), jsonGenerator);
            jsonGenerator.writeFieldName("space_shortage");
            StoneSerializers.uInt64().serialize(Long.valueOf(insufficientQuotaAmounts.spaceShortage), jsonGenerator);
            jsonGenerator.writeFieldName("space_left");
            StoneSerializers.uInt64().serialize(Long.valueOf(insufficientQuotaAmounts.spaceLeft), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public InsufficientQuotaAmounts deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Long lDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Long lDeserialize2 = null;
                Long lDeserialize3 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("space_needed".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else if ("space_shortage".equals(currentName)) {
                        lDeserialize2 = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else if ("space_left".equals(currentName)) {
                        lDeserialize3 = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"space_needed\" missing.");
                }
                if (lDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"space_shortage\" missing.");
                }
                if (lDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"space_left\" missing.");
                }
                InsufficientQuotaAmounts insufficientQuotaAmounts = new InsufficientQuotaAmounts(lDeserialize.longValue(), lDeserialize2.longValue(), lDeserialize3.longValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(insufficientQuotaAmounts, insufficientQuotaAmounts.toStringMultiline());
                return insufficientQuotaAmounts;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
