package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.FailureDetailsLogInfo;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class EmmErrorDetails {

    @Nonnull
    protected final FailureDetailsLogInfo errorDetails;

    public EmmErrorDetails(@Nonnull FailureDetailsLogInfo failureDetailsLogInfo) {
        if (failureDetailsLogInfo == null) {
            throw new IllegalArgumentException("Required value for 'errorDetails' is null");
        }
        this.errorDetails = failureDetailsLogInfo;
    }

    @Nonnull
    public FailureDetailsLogInfo getErrorDetails() {
        return this.errorDetails;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.errorDetails});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        FailureDetailsLogInfo failureDetailsLogInfo = this.errorDetails;
        FailureDetailsLogInfo failureDetailsLogInfo2 = ((EmmErrorDetails) obj).errorDetails;
        return failureDetailsLogInfo == failureDetailsLogInfo2 || failureDetailsLogInfo.equals(failureDetailsLogInfo2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<EmmErrorDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(EmmErrorDetails emmErrorDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("error_details");
            FailureDetailsLogInfo.Serializer.INSTANCE.serialize(emmErrorDetails.errorDetails, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public EmmErrorDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            FailureDetailsLogInfo failureDetailsLogInfoDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("error_details".equals(currentName)) {
                        failureDetailsLogInfoDeserialize = FailureDetailsLogInfo.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (failureDetailsLogInfoDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"error_details\" missing.");
                }
                EmmErrorDetails emmErrorDetails = new EmmErrorDetails(failureDetailsLogInfoDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(emmErrorDetails, emmErrorDetails.toStringMultiline());
                return emmErrorDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
