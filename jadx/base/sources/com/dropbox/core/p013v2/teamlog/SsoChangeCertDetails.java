package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.Certificate;
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
public class SsoChangeCertDetails {

    @Nonnull
    protected final Certificate newCertificateDetails;

    @Nullable
    protected final Certificate previousCertificateDetails;

    public SsoChangeCertDetails(@Nonnull Certificate certificate, @Nullable Certificate certificate2) {
        this.previousCertificateDetails = certificate2;
        if (certificate == null) {
            throw new IllegalArgumentException("Required value for 'newCertificateDetails' is null");
        }
        this.newCertificateDetails = certificate;
    }

    public SsoChangeCertDetails(@Nonnull Certificate certificate) {
        this(certificate, null);
    }

    @Nonnull
    public Certificate getNewCertificateDetails() {
        return this.newCertificateDetails;
    }

    @Nullable
    public Certificate getPreviousCertificateDetails() {
        return this.previousCertificateDetails;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.previousCertificateDetails, this.newCertificateDetails});
    }

    public boolean equals(Object obj) {
        Certificate certificate;
        Certificate certificate2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SsoChangeCertDetails ssoChangeCertDetails = (SsoChangeCertDetails) obj;
        Certificate certificate3 = this.newCertificateDetails;
        Certificate certificate4 = ssoChangeCertDetails.newCertificateDetails;
        return (certificate3 == certificate4 || certificate3.equals(certificate4)) && ((certificate = this.previousCertificateDetails) == (certificate2 = ssoChangeCertDetails.previousCertificateDetails) || (certificate != null && certificate.equals(certificate2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SsoChangeCertDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SsoChangeCertDetails ssoChangeCertDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_certificate_details");
            Certificate.Serializer.INSTANCE.serialize(ssoChangeCertDetails.newCertificateDetails, jsonGenerator);
            if (ssoChangeCertDetails.previousCertificateDetails != null) {
                jsonGenerator.writeFieldName("previous_certificate_details");
                StoneSerializers.nullableStruct(Certificate.Serializer.INSTANCE).serialize(ssoChangeCertDetails.previousCertificateDetails, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SsoChangeCertDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Certificate certificateDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Certificate certificate = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_certificate_details".equals(currentName)) {
                        certificateDeserialize = Certificate.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_certificate_details".equals(currentName)) {
                        certificate = (Certificate) StoneSerializers.nullableStruct(Certificate.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (certificateDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_certificate_details\" missing.");
                }
                SsoChangeCertDetails ssoChangeCertDetails = new SsoChangeCertDetails(certificateDeserialize, certificate);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(ssoChangeCertDetails, ssoChangeCertDetails.toStringMultiline());
                return ssoChangeCertDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
