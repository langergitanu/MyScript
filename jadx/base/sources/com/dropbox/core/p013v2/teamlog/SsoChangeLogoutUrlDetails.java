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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class SsoChangeLogoutUrlDetails {

    @Nullable
    protected final String newValue;

    @Nullable
    protected final String previousValue;

    public SsoChangeLogoutUrlDetails(@Nullable String str, @Nullable String str2) {
        this.previousValue = str;
        this.newValue = str2;
    }

    public SsoChangeLogoutUrlDetails() {
        this(null, null);
    }

    @Nullable
    public String getPreviousValue() {
        return this.previousValue;
    }

    @Nullable
    public String getNewValue() {
        return this.newValue;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected String previousValue = null;
        protected String newValue = null;

        protected Builder() {
        }

        public Builder withPreviousValue(String str) {
            this.previousValue = str;
            return this;
        }

        public Builder withNewValue(String str) {
            this.newValue = str;
            return this;
        }

        public SsoChangeLogoutUrlDetails build() {
            return new SsoChangeLogoutUrlDetails(this.previousValue, this.newValue);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.previousValue, this.newValue});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SsoChangeLogoutUrlDetails ssoChangeLogoutUrlDetails = (SsoChangeLogoutUrlDetails) obj;
        String str3 = this.previousValue;
        String str4 = ssoChangeLogoutUrlDetails.previousValue;
        return (str3 == str4 || (str3 != null && str3.equals(str4))) && ((str = this.newValue) == (str2 = ssoChangeLogoutUrlDetails.newValue) || (str != null && str.equals(str2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SsoChangeLogoutUrlDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SsoChangeLogoutUrlDetails ssoChangeLogoutUrlDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (ssoChangeLogoutUrlDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(ssoChangeLogoutUrlDetails.previousValue, jsonGenerator);
            }
            if (ssoChangeLogoutUrlDetails.newValue != null) {
                jsonGenerator.writeFieldName("new_value");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(ssoChangeLogoutUrlDetails.newValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SsoChangeLogoutUrlDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String str = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String str2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("previous_value".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("new_value".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                SsoChangeLogoutUrlDetails ssoChangeLogoutUrlDetails = new SsoChangeLogoutUrlDetails(str, str2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(ssoChangeLogoutUrlDetails, ssoChangeLogoutUrlDetails.toStringMultiline());
                return ssoChangeLogoutUrlDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
