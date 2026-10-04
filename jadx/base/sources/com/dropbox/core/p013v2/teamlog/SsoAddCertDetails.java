package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.Certificate;
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
public class SsoAddCertDetails {

    @Nonnull
    protected final Certificate certificateDetails;

    public SsoAddCertDetails(@Nonnull Certificate certificate) {
        if (certificate == null) {
            throw new IllegalArgumentException("Required value for 'certificateDetails' is null");
        }
        this.certificateDetails = certificate;
    }

    @Nonnull
    public Certificate getCertificateDetails() {
        return this.certificateDetails;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.certificateDetails});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        Certificate certificate = this.certificateDetails;
        Certificate certificate2 = ((SsoAddCertDetails) obj).certificateDetails;
        return certificate == certificate2 || certificate.equals(certificate2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SsoAddCertDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SsoAddCertDetails ssoAddCertDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("certificate_details");
            Certificate.Serializer.INSTANCE.serialize(ssoAddCertDetails.certificateDetails, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SsoAddCertDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Certificate certificateDeserialize = null;
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
                    if ("certificate_details".equals(currentName)) {
                        certificateDeserialize = Certificate.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (certificateDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"certificate_details\" missing.");
                }
                SsoAddCertDetails ssoAddCertDetails = new SsoAddCertDetails(certificateDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(ssoAddCertDetails, ssoAddCertDetails.toStringMultiline());
                return ssoAddCertDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
