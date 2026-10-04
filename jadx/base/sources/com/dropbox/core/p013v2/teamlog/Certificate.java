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
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class Certificate {

    @Nullable
    protected final String commonName;

    @Nonnull
    protected final String expirationDate;

    @Nonnull
    protected final String issueDate;

    @Nonnull
    protected final String issuer;

    @Nonnull
    protected final String serialNumber;

    @Nonnull
    protected final String sha1Fingerprint;

    @Nonnull
    protected final String subject;

    public Certificate(@Nonnull String str, @Nonnull String str2, @Nonnull String str3, @Nonnull String str4, @Nonnull String str5, @Nonnull String str6, @Nullable String str7) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'subject' is null");
        }
        this.subject = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'issuer' is null");
        }
        this.issuer = str2;
        if (str3 == null) {
            throw new IllegalArgumentException("Required value for 'issueDate' is null");
        }
        this.issueDate = str3;
        if (str4 == null) {
            throw new IllegalArgumentException("Required value for 'expirationDate' is null");
        }
        this.expirationDate = str4;
        if (str5 == null) {
            throw new IllegalArgumentException("Required value for 'serialNumber' is null");
        }
        this.serialNumber = str5;
        if (str6 == null) {
            throw new IllegalArgumentException("Required value for 'sha1Fingerprint' is null");
        }
        this.sha1Fingerprint = str6;
        this.commonName = str7;
    }

    public Certificate(@Nonnull String str, @Nonnull String str2, @Nonnull String str3, @Nonnull String str4, @Nonnull String str5, @Nonnull String str6) {
        this(str, str2, str3, str4, str5, str6, null);
    }

    @Nonnull
    public String getSubject() {
        return this.subject;
    }

    @Nonnull
    public String getIssuer() {
        return this.issuer;
    }

    @Nonnull
    public String getIssueDate() {
        return this.issueDate;
    }

    @Nonnull
    public String getExpirationDate() {
        return this.expirationDate;
    }

    @Nonnull
    public String getSerialNumber() {
        return this.serialNumber;
    }

    @Nonnull
    public String getSha1Fingerprint() {
        return this.sha1Fingerprint;
    }

    @Nullable
    public String getCommonName() {
        return this.commonName;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.subject, this.issuer, this.issueDate, this.expirationDate, this.serialNumber, this.sha1Fingerprint, this.commonName});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        Certificate certificate = (Certificate) obj;
        String str13 = this.subject;
        String str14 = certificate.subject;
        return (str13 == str14 || str13.equals(str14)) && ((str = this.issuer) == (str2 = certificate.issuer) || str.equals(str2)) && (((str3 = this.issueDate) == (str4 = certificate.issueDate) || str3.equals(str4)) && (((str5 = this.expirationDate) == (str6 = certificate.expirationDate) || str5.equals(str6)) && (((str7 = this.serialNumber) == (str8 = certificate.serialNumber) || str7.equals(str8)) && (((str9 = this.sha1Fingerprint) == (str10 = certificate.sha1Fingerprint) || str9.equals(str10)) && ((str11 = this.commonName) == (str12 = certificate.commonName) || (str11 != null && str11.equals(str12)))))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<Certificate> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(Certificate certificate, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("subject");
            StoneSerializers.string().serialize(certificate.subject, jsonGenerator);
            jsonGenerator.writeFieldName("issuer");
            StoneSerializers.string().serialize(certificate.issuer, jsonGenerator);
            jsonGenerator.writeFieldName("issue_date");
            StoneSerializers.string().serialize(certificate.issueDate, jsonGenerator);
            jsonGenerator.writeFieldName("expiration_date");
            StoneSerializers.string().serialize(certificate.expirationDate, jsonGenerator);
            jsonGenerator.writeFieldName("serial_number");
            StoneSerializers.string().serialize(certificate.serialNumber, jsonGenerator);
            jsonGenerator.writeFieldName("sha1_fingerprint");
            StoneSerializers.string().serialize(certificate.sha1Fingerprint, jsonGenerator);
            if (certificate.commonName != null) {
                jsonGenerator.writeFieldName("common_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(certificate.commonName, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public Certificate deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                String strDeserialize2 = null;
                String strDeserialize3 = null;
                String strDeserialize4 = null;
                String strDeserialize5 = null;
                String strDeserialize6 = null;
                String str = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("subject".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("issuer".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("issue_date".equals(currentName)) {
                        strDeserialize3 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("expiration_date".equals(currentName)) {
                        strDeserialize4 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("serial_number".equals(currentName)) {
                        strDeserialize5 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("sha1_fingerprint".equals(currentName)) {
                        strDeserialize6 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("common_name".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"subject\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"issuer\" missing.");
                }
                if (strDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"issue_date\" missing.");
                }
                if (strDeserialize4 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"expiration_date\" missing.");
                }
                if (strDeserialize5 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"serial_number\" missing.");
                }
                if (strDeserialize6 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"sha1_fingerprint\" missing.");
                }
                Certificate certificate = new Certificate(strDeserialize, strDeserialize2, strDeserialize3, strDeserialize4, strDeserialize5, strDeserialize6, str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(certificate, certificate.toStringMultiline());
                return certificate;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
