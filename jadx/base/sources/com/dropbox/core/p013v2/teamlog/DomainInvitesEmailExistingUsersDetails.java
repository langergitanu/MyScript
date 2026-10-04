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

/* JADX INFO: loaded from: classes5.dex */
public class DomainInvitesEmailExistingUsersDetails {

    @Nonnull
    protected final String domainName;
    protected final long numRecipients;

    public DomainInvitesEmailExistingUsersDetails(@Nonnull String str, long j) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'domainName' is null");
        }
        this.domainName = str;
        this.numRecipients = j;
    }

    @Nonnull
    public String getDomainName() {
        return this.domainName;
    }

    public long getNumRecipients() {
        return this.numRecipients;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.domainName, Long.valueOf(this.numRecipients)});
    }

    public boolean equals(Object obj) {
        DomainInvitesEmailExistingUsersDetails domainInvitesEmailExistingUsersDetails;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.domainName) == (str2 = (domainInvitesEmailExistingUsersDetails = (DomainInvitesEmailExistingUsersDetails) obj).domainName) || str.equals(str2)) && this.numRecipients == domainInvitesEmailExistingUsersDetails.numRecipients;
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<DomainInvitesEmailExistingUsersDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(DomainInvitesEmailExistingUsersDetails domainInvitesEmailExistingUsersDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("domain_name");
            StoneSerializers.string().serialize(domainInvitesEmailExistingUsersDetails.domainName, jsonGenerator);
            jsonGenerator.writeFieldName("num_recipients");
            StoneSerializers.uInt64().serialize(Long.valueOf(domainInvitesEmailExistingUsersDetails.numRecipients), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public DomainInvitesEmailExistingUsersDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Long lDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("domain_name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("num_recipients".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"domain_name\" missing.");
                }
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"num_recipients\" missing.");
                }
                DomainInvitesEmailExistingUsersDetails domainInvitesEmailExistingUsersDetails = new DomainInvitesEmailExistingUsersDetails(strDeserialize, lDeserialize.longValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(domainInvitesEmailExistingUsersDetails, domainInvitesEmailExistingUsersDetails.toStringMultiline());
                return domainInvitesEmailExistingUsersDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
