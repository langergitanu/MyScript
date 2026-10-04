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
public class CreateTeamInviteLinkDetails {

    @Nonnull
    protected final String expiryDate;

    @Nonnull
    protected final String linkUrl;

    public CreateTeamInviteLinkDetails(@Nonnull String str, @Nonnull String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'linkUrl' is null");
        }
        this.linkUrl = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'expiryDate' is null");
        }
        this.expiryDate = str2;
    }

    @Nonnull
    public String getLinkUrl() {
        return this.linkUrl;
    }

    @Nonnull
    public String getExpiryDate() {
        return this.expiryDate;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.linkUrl, this.expiryDate});
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
        CreateTeamInviteLinkDetails createTeamInviteLinkDetails = (CreateTeamInviteLinkDetails) obj;
        String str3 = this.linkUrl;
        String str4 = createTeamInviteLinkDetails.linkUrl;
        return (str3 == str4 || str3.equals(str4)) && ((str = this.expiryDate) == (str2 = createTeamInviteLinkDetails.expiryDate) || str.equals(str2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<CreateTeamInviteLinkDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(CreateTeamInviteLinkDetails createTeamInviteLinkDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("link_url");
            StoneSerializers.string().serialize(createTeamInviteLinkDetails.linkUrl, jsonGenerator);
            jsonGenerator.writeFieldName("expiry_date");
            StoneSerializers.string().serialize(createTeamInviteLinkDetails.expiryDate, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public CreateTeamInviteLinkDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("link_url".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("expiry_date".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"link_url\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"expiry_date\" missing.");
                }
                CreateTeamInviteLinkDetails createTeamInviteLinkDetails = new CreateTeamInviteLinkDetails(strDeserialize, strDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(createTeamInviteLinkDetails, createTeamInviteLinkDetails.toStringMultiline());
                return createTeamInviteLinkDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
