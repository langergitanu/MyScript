package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.WebSessionsFixedLengthPolicy;
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
public class WebSessionsChangeFixedLengthPolicyDetails {

    @Nullable
    protected final WebSessionsFixedLengthPolicy newValue;

    @Nullable
    protected final WebSessionsFixedLengthPolicy previousValue;

    public WebSessionsChangeFixedLengthPolicyDetails(@Nullable WebSessionsFixedLengthPolicy webSessionsFixedLengthPolicy, @Nullable WebSessionsFixedLengthPolicy webSessionsFixedLengthPolicy2) {
        this.newValue = webSessionsFixedLengthPolicy;
        this.previousValue = webSessionsFixedLengthPolicy2;
    }

    public WebSessionsChangeFixedLengthPolicyDetails() {
        this(null, null);
    }

    @Nullable
    public WebSessionsFixedLengthPolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public WebSessionsFixedLengthPolicy getPreviousValue() {
        return this.previousValue;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected WebSessionsFixedLengthPolicy newValue = null;
        protected WebSessionsFixedLengthPolicy previousValue = null;

        protected Builder() {
        }

        public Builder withNewValue(WebSessionsFixedLengthPolicy webSessionsFixedLengthPolicy) {
            this.newValue = webSessionsFixedLengthPolicy;
            return this;
        }

        public Builder withPreviousValue(WebSessionsFixedLengthPolicy webSessionsFixedLengthPolicy) {
            this.previousValue = webSessionsFixedLengthPolicy;
            return this;
        }

        public WebSessionsChangeFixedLengthPolicyDetails build() {
            return new WebSessionsChangeFixedLengthPolicyDetails(this.newValue, this.previousValue);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        WebSessionsFixedLengthPolicy webSessionsFixedLengthPolicy;
        WebSessionsFixedLengthPolicy webSessionsFixedLengthPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        WebSessionsChangeFixedLengthPolicyDetails webSessionsChangeFixedLengthPolicyDetails = (WebSessionsChangeFixedLengthPolicyDetails) obj;
        WebSessionsFixedLengthPolicy webSessionsFixedLengthPolicy3 = this.newValue;
        WebSessionsFixedLengthPolicy webSessionsFixedLengthPolicy4 = webSessionsChangeFixedLengthPolicyDetails.newValue;
        return (webSessionsFixedLengthPolicy3 == webSessionsFixedLengthPolicy4 || (webSessionsFixedLengthPolicy3 != null && webSessionsFixedLengthPolicy3.equals(webSessionsFixedLengthPolicy4))) && ((webSessionsFixedLengthPolicy = this.previousValue) == (webSessionsFixedLengthPolicy2 = webSessionsChangeFixedLengthPolicyDetails.previousValue) || (webSessionsFixedLengthPolicy != null && webSessionsFixedLengthPolicy.equals(webSessionsFixedLengthPolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<WebSessionsChangeFixedLengthPolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(WebSessionsChangeFixedLengthPolicyDetails webSessionsChangeFixedLengthPolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (webSessionsChangeFixedLengthPolicyDetails.newValue != null) {
                jsonGenerator.writeFieldName("new_value");
                StoneSerializers.nullable(WebSessionsFixedLengthPolicy.Serializer.INSTANCE).serialize(webSessionsChangeFixedLengthPolicyDetails.newValue, jsonGenerator);
            }
            if (webSessionsChangeFixedLengthPolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(WebSessionsFixedLengthPolicy.Serializer.INSTANCE).serialize(webSessionsChangeFixedLengthPolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public WebSessionsChangeFixedLengthPolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            WebSessionsFixedLengthPolicy webSessionsFixedLengthPolicy = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                WebSessionsFixedLengthPolicy webSessionsFixedLengthPolicy2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        webSessionsFixedLengthPolicy = (WebSessionsFixedLengthPolicy) StoneSerializers.nullable(WebSessionsFixedLengthPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        webSessionsFixedLengthPolicy2 = (WebSessionsFixedLengthPolicy) StoneSerializers.nullable(WebSessionsFixedLengthPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                WebSessionsChangeFixedLengthPolicyDetails webSessionsChangeFixedLengthPolicyDetails = new WebSessionsChangeFixedLengthPolicyDetails(webSessionsFixedLengthPolicy, webSessionsFixedLengthPolicy2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(webSessionsChangeFixedLengthPolicyDetails, webSessionsChangeFixedLengthPolicyDetails.toStringMultiline());
                return webSessionsChangeFixedLengthPolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
