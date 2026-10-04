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
public class DomainVerificationAddDomainFailDetails {

    @Nonnull
    protected final String domainName;

    @Nullable
    protected final String verificationMethod;

    public DomainVerificationAddDomainFailDetails(@Nonnull String str, @Nullable String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'domainName' is null");
        }
        this.domainName = str;
        this.verificationMethod = str2;
    }

    public DomainVerificationAddDomainFailDetails(@Nonnull String str) {
        this(str, null);
    }

    @Nonnull
    public String getDomainName() {
        return this.domainName;
    }

    @Nullable
    public String getVerificationMethod() {
        return this.verificationMethod;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.domainName, this.verificationMethod});
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
        DomainVerificationAddDomainFailDetails domainVerificationAddDomainFailDetails = (DomainVerificationAddDomainFailDetails) obj;
        String str3 = this.domainName;
        String str4 = domainVerificationAddDomainFailDetails.domainName;
        return (str3 == str4 || str3.equals(str4)) && ((str = this.verificationMethod) == (str2 = domainVerificationAddDomainFailDetails.verificationMethod) || (str != null && str.equals(str2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<DomainVerificationAddDomainFailDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(DomainVerificationAddDomainFailDetails domainVerificationAddDomainFailDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("domain_name");
            StoneSerializers.string().serialize(domainVerificationAddDomainFailDetails.domainName, jsonGenerator);
            if (domainVerificationAddDomainFailDetails.verificationMethod != null) {
                jsonGenerator.writeFieldName("verification_method");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(domainVerificationAddDomainFailDetails.verificationMethod, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public DomainVerificationAddDomainFailDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String str = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("domain_name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("verification_method".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"domain_name\" missing.");
                }
                DomainVerificationAddDomainFailDetails domainVerificationAddDomainFailDetails = new DomainVerificationAddDomainFailDetails(strDeserialize, str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(domainVerificationAddDomainFailDetails, domainVerificationAddDomainFailDetails.toStringMultiline());
                return domainVerificationAddDomainFailDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
