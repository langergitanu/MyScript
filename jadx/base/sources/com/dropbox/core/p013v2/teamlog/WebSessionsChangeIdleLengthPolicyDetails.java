package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.WebSessionsIdleLengthPolicy;
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
public class WebSessionsChangeIdleLengthPolicyDetails {

    @Nullable
    protected final WebSessionsIdleLengthPolicy newValue;

    @Nullable
    protected final WebSessionsIdleLengthPolicy previousValue;

    public WebSessionsChangeIdleLengthPolicyDetails(@Nullable WebSessionsIdleLengthPolicy webSessionsIdleLengthPolicy, @Nullable WebSessionsIdleLengthPolicy webSessionsIdleLengthPolicy2) {
        this.newValue = webSessionsIdleLengthPolicy;
        this.previousValue = webSessionsIdleLengthPolicy2;
    }

    public WebSessionsChangeIdleLengthPolicyDetails() {
        this(null, null);
    }

    @Nullable
    public WebSessionsIdleLengthPolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public WebSessionsIdleLengthPolicy getPreviousValue() {
        return this.previousValue;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected WebSessionsIdleLengthPolicy newValue = null;
        protected WebSessionsIdleLengthPolicy previousValue = null;

        protected Builder() {
        }

        public Builder withNewValue(WebSessionsIdleLengthPolicy webSessionsIdleLengthPolicy) {
            this.newValue = webSessionsIdleLengthPolicy;
            return this;
        }

        public Builder withPreviousValue(WebSessionsIdleLengthPolicy webSessionsIdleLengthPolicy) {
            this.previousValue = webSessionsIdleLengthPolicy;
            return this;
        }

        public WebSessionsChangeIdleLengthPolicyDetails build() {
            return new WebSessionsChangeIdleLengthPolicyDetails(this.newValue, this.previousValue);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        WebSessionsIdleLengthPolicy webSessionsIdleLengthPolicy;
        WebSessionsIdleLengthPolicy webSessionsIdleLengthPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        WebSessionsChangeIdleLengthPolicyDetails webSessionsChangeIdleLengthPolicyDetails = (WebSessionsChangeIdleLengthPolicyDetails) obj;
        WebSessionsIdleLengthPolicy webSessionsIdleLengthPolicy3 = this.newValue;
        WebSessionsIdleLengthPolicy webSessionsIdleLengthPolicy4 = webSessionsChangeIdleLengthPolicyDetails.newValue;
        return (webSessionsIdleLengthPolicy3 == webSessionsIdleLengthPolicy4 || (webSessionsIdleLengthPolicy3 != null && webSessionsIdleLengthPolicy3.equals(webSessionsIdleLengthPolicy4))) && ((webSessionsIdleLengthPolicy = this.previousValue) == (webSessionsIdleLengthPolicy2 = webSessionsChangeIdleLengthPolicyDetails.previousValue) || (webSessionsIdleLengthPolicy != null && webSessionsIdleLengthPolicy.equals(webSessionsIdleLengthPolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<WebSessionsChangeIdleLengthPolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(WebSessionsChangeIdleLengthPolicyDetails webSessionsChangeIdleLengthPolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (webSessionsChangeIdleLengthPolicyDetails.newValue != null) {
                jsonGenerator.writeFieldName("new_value");
                StoneSerializers.nullable(WebSessionsIdleLengthPolicy.Serializer.INSTANCE).serialize(webSessionsChangeIdleLengthPolicyDetails.newValue, jsonGenerator);
            }
            if (webSessionsChangeIdleLengthPolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(WebSessionsIdleLengthPolicy.Serializer.INSTANCE).serialize(webSessionsChangeIdleLengthPolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public WebSessionsChangeIdleLengthPolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            WebSessionsIdleLengthPolicy webSessionsIdleLengthPolicy = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                WebSessionsIdleLengthPolicy webSessionsIdleLengthPolicy2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        webSessionsIdleLengthPolicy = (WebSessionsIdleLengthPolicy) StoneSerializers.nullable(WebSessionsIdleLengthPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        webSessionsIdleLengthPolicy2 = (WebSessionsIdleLengthPolicy) StoneSerializers.nullable(WebSessionsIdleLengthPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                WebSessionsChangeIdleLengthPolicyDetails webSessionsChangeIdleLengthPolicyDetails = new WebSessionsChangeIdleLengthPolicyDetails(webSessionsIdleLengthPolicy, webSessionsIdleLengthPolicy2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(webSessionsChangeIdleLengthPolicyDetails, webSessionsChangeIdleLengthPolicyDetails.toStringMultiline());
                return webSessionsChangeIdleLengthPolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
