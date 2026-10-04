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
public class FailureDetailsLogInfo {

    @Nullable
    protected final String technicalErrorMessage;

    @Nullable
    protected final String userFriendlyMessage;

    public FailureDetailsLogInfo(@Nullable String str, @Nullable String str2) {
        this.userFriendlyMessage = str;
        this.technicalErrorMessage = str2;
    }

    public FailureDetailsLogInfo() {
        this(null, null);
    }

    @Nullable
    public String getUserFriendlyMessage() {
        return this.userFriendlyMessage;
    }

    @Nullable
    public String getTechnicalErrorMessage() {
        return this.technicalErrorMessage;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected String userFriendlyMessage = null;
        protected String technicalErrorMessage = null;

        protected Builder() {
        }

        public Builder withUserFriendlyMessage(String str) {
            this.userFriendlyMessage = str;
            return this;
        }

        public Builder withTechnicalErrorMessage(String str) {
            this.technicalErrorMessage = str;
            return this;
        }

        public FailureDetailsLogInfo build() {
            return new FailureDetailsLogInfo(this.userFriendlyMessage, this.technicalErrorMessage);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.userFriendlyMessage, this.technicalErrorMessage});
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
        FailureDetailsLogInfo failureDetailsLogInfo = (FailureDetailsLogInfo) obj;
        String str3 = this.userFriendlyMessage;
        String str4 = failureDetailsLogInfo.userFriendlyMessage;
        return (str3 == str4 || (str3 != null && str3.equals(str4))) && ((str = this.technicalErrorMessage) == (str2 = failureDetailsLogInfo.technicalErrorMessage) || (str != null && str.equals(str2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FailureDetailsLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FailureDetailsLogInfo failureDetailsLogInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (failureDetailsLogInfo.userFriendlyMessage != null) {
                jsonGenerator.writeFieldName("user_friendly_message");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(failureDetailsLogInfo.userFriendlyMessage, jsonGenerator);
            }
            if (failureDetailsLogInfo.technicalErrorMessage != null) {
                jsonGenerator.writeFieldName("technical_error_message");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(failureDetailsLogInfo.technicalErrorMessage, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FailureDetailsLogInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    if ("user_friendly_message".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("technical_error_message".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                FailureDetailsLogInfo failureDetailsLogInfo = new FailureDetailsLogInfo(str, str2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(failureDetailsLogInfo, failureDetailsLogInfo.toStringMultiline());
                return failureDetailsLogInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
