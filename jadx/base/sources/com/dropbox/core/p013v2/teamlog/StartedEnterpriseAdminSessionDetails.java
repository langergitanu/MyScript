package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.FedExtraDetails;
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
public class StartedEnterpriseAdminSessionDetails {

    @Nonnull
    protected final FedExtraDetails federationExtraDetails;

    public StartedEnterpriseAdminSessionDetails(@Nonnull FedExtraDetails fedExtraDetails) {
        if (fedExtraDetails == null) {
            throw new IllegalArgumentException("Required value for 'federationExtraDetails' is null");
        }
        this.federationExtraDetails = fedExtraDetails;
    }

    @Nonnull
    public FedExtraDetails getFederationExtraDetails() {
        return this.federationExtraDetails;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.federationExtraDetails});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        FedExtraDetails fedExtraDetails = this.federationExtraDetails;
        FedExtraDetails fedExtraDetails2 = ((StartedEnterpriseAdminSessionDetails) obj).federationExtraDetails;
        return fedExtraDetails == fedExtraDetails2 || fedExtraDetails.equals(fedExtraDetails2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<StartedEnterpriseAdminSessionDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(StartedEnterpriseAdminSessionDetails startedEnterpriseAdminSessionDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("federation_extra_details");
            FedExtraDetails.Serializer.INSTANCE.serialize(startedEnterpriseAdminSessionDetails.federationExtraDetails, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public StartedEnterpriseAdminSessionDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            FedExtraDetails fedExtraDetailsDeserialize = null;
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
                    if ("federation_extra_details".equals(currentName)) {
                        fedExtraDetailsDeserialize = FedExtraDetails.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (fedExtraDetailsDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"federation_extra_details\" missing.");
                }
                StartedEnterpriseAdminSessionDetails startedEnterpriseAdminSessionDetails = new StartedEnterpriseAdminSessionDetails(fedExtraDetailsDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(startedEnterpriseAdminSessionDetails, startedEnterpriseAdminSessionDetails.toStringMultiline());
                return startedEnterpriseAdminSessionDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
