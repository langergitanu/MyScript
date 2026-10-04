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

/* JADX INFO: loaded from: classes5.dex */
public class SsoChangeSamlIdentityModeDetails {
    protected final long newValue;
    protected final long previousValue;

    public SsoChangeSamlIdentityModeDetails(long j, long j2) {
        this.previousValue = j;
        this.newValue = j2;
    }

    public long getPreviousValue() {
        return this.previousValue;
    }

    public long getNewValue() {
        return this.newValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.previousValue), Long.valueOf(this.newValue)});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            SsoChangeSamlIdentityModeDetails ssoChangeSamlIdentityModeDetails = (SsoChangeSamlIdentityModeDetails) obj;
            if (this.previousValue == ssoChangeSamlIdentityModeDetails.previousValue && this.newValue == ssoChangeSamlIdentityModeDetails.newValue) {
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

    static class Serializer extends StructSerializer<SsoChangeSamlIdentityModeDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SsoChangeSamlIdentityModeDetails ssoChangeSamlIdentityModeDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("previous_value");
            StoneSerializers.int64().serialize(Long.valueOf(ssoChangeSamlIdentityModeDetails.previousValue), jsonGenerator);
            jsonGenerator.writeFieldName("new_value");
            StoneSerializers.int64().serialize(Long.valueOf(ssoChangeSamlIdentityModeDetails.newValue), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SsoChangeSamlIdentityModeDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("previous_value".equals(currentName)) {
                        lDeserialize = StoneSerializers.int64().deserialize(jsonParser);
                    } else if ("new_value".equals(currentName)) {
                        lDeserialize2 = StoneSerializers.int64().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                if (lDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                SsoChangeSamlIdentityModeDetails ssoChangeSamlIdentityModeDetails = new SsoChangeSamlIdentityModeDetails(lDeserialize.longValue(), lDeserialize2.longValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(ssoChangeSamlIdentityModeDetails, ssoChangeSamlIdentityModeDetails.toStringMultiline());
                return ssoChangeSamlIdentityModeDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
