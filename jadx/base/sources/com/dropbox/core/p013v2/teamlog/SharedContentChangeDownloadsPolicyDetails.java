package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.DownloadPolicyType;
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
public class SharedContentChangeDownloadsPolicyDetails {

    @Nonnull
    protected final DownloadPolicyType newValue;

    @Nullable
    protected final DownloadPolicyType previousValue;

    public SharedContentChangeDownloadsPolicyDetails(@Nonnull DownloadPolicyType downloadPolicyType, @Nullable DownloadPolicyType downloadPolicyType2) {
        if (downloadPolicyType == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = downloadPolicyType;
        this.previousValue = downloadPolicyType2;
    }

    public SharedContentChangeDownloadsPolicyDetails(@Nonnull DownloadPolicyType downloadPolicyType) {
        this(downloadPolicyType, null);
    }

    @Nonnull
    public DownloadPolicyType getNewValue() {
        return this.newValue;
    }

    @Nullable
    public DownloadPolicyType getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        DownloadPolicyType downloadPolicyType;
        DownloadPolicyType downloadPolicyType2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SharedContentChangeDownloadsPolicyDetails sharedContentChangeDownloadsPolicyDetails = (SharedContentChangeDownloadsPolicyDetails) obj;
        DownloadPolicyType downloadPolicyType3 = this.newValue;
        DownloadPolicyType downloadPolicyType4 = sharedContentChangeDownloadsPolicyDetails.newValue;
        return (downloadPolicyType3 == downloadPolicyType4 || downloadPolicyType3.equals(downloadPolicyType4)) && ((downloadPolicyType = this.previousValue) == (downloadPolicyType2 = sharedContentChangeDownloadsPolicyDetails.previousValue) || (downloadPolicyType != null && downloadPolicyType.equals(downloadPolicyType2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedContentChangeDownloadsPolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedContentChangeDownloadsPolicyDetails sharedContentChangeDownloadsPolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            DownloadPolicyType.Serializer.INSTANCE.serialize(sharedContentChangeDownloadsPolicyDetails.newValue, jsonGenerator);
            if (sharedContentChangeDownloadsPolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(DownloadPolicyType.Serializer.INSTANCE).serialize(sharedContentChangeDownloadsPolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedContentChangeDownloadsPolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            DownloadPolicyType downloadPolicyTypeDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                DownloadPolicyType downloadPolicyType = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        downloadPolicyTypeDeserialize = DownloadPolicyType.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        downloadPolicyType = (DownloadPolicyType) StoneSerializers.nullable(DownloadPolicyType.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (downloadPolicyTypeDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                SharedContentChangeDownloadsPolicyDetails sharedContentChangeDownloadsPolicyDetails = new SharedContentChangeDownloadsPolicyDetails(downloadPolicyTypeDeserialize, downloadPolicyType);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedContentChangeDownloadsPolicyDetails, sharedContentChangeDownloadsPolicyDetails.toStringMultiline());
                return sharedContentChangeDownloadsPolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
