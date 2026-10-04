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
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class DomainVerificationAddDomainSuccessDetails {

    @Nonnull
    protected final List<String> domainNames;

    @Nullable
    protected final String verificationMethod;

    public DomainVerificationAddDomainSuccessDetails(@Nonnull List<String> list, @Nullable String str) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'domainNames' is null");
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'domainNames' is null");
            }
        }
        this.domainNames = list;
        this.verificationMethod = str;
    }

    public DomainVerificationAddDomainSuccessDetails(@Nonnull List<String> list) {
        this(list, null);
    }

    @Nonnull
    public List<String> getDomainNames() {
        return this.domainNames;
    }

    @Nullable
    public String getVerificationMethod() {
        return this.verificationMethod;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.domainNames, this.verificationMethod});
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
        DomainVerificationAddDomainSuccessDetails domainVerificationAddDomainSuccessDetails = (DomainVerificationAddDomainSuccessDetails) obj;
        List<String> list = this.domainNames;
        List<String> list2 = domainVerificationAddDomainSuccessDetails.domainNames;
        return (list == list2 || list.equals(list2)) && ((str = this.verificationMethod) == (str2 = domainVerificationAddDomainSuccessDetails.verificationMethod) || (str != null && str.equals(str2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<DomainVerificationAddDomainSuccessDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(DomainVerificationAddDomainSuccessDetails domainVerificationAddDomainSuccessDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("domain_names");
            StoneSerializers.list(StoneSerializers.string()).serialize(domainVerificationAddDomainSuccessDetails.domainNames, jsonGenerator);
            if (domainVerificationAddDomainSuccessDetails.verificationMethod != null) {
                jsonGenerator.writeFieldName("verification_method");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(domainVerificationAddDomainSuccessDetails.verificationMethod, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public DomainVerificationAddDomainSuccessDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            List list = null;
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
                    if ("domain_names".equals(currentName)) {
                        list = (List) StoneSerializers.list(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("verification_method".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"domain_names\" missing.");
                }
                DomainVerificationAddDomainSuccessDetails domainVerificationAddDomainSuccessDetails = new DomainVerificationAddDomainSuccessDetails(list, str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(domainVerificationAddDomainSuccessDetails, domainVerificationAddDomainSuccessDetails.toStringMultiline());
                return domainVerificationAddDomainSuccessDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
