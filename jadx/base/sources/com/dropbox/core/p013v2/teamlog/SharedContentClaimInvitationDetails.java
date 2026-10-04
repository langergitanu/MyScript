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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class SharedContentClaimInvitationDetails {

    @Nullable
    protected final String sharedContentLink;

    public SharedContentClaimInvitationDetails(@Nullable String str) {
        this.sharedContentLink = str;
    }

    public SharedContentClaimInvitationDetails() {
        this(null);
    }

    @Nullable
    public String getSharedContentLink() {
        return this.sharedContentLink;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.sharedContentLink});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        String str = this.sharedContentLink;
        String str2 = ((SharedContentClaimInvitationDetails) obj).sharedContentLink;
        return str == str2 || (str != null && str.equals(str2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedContentClaimInvitationDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedContentClaimInvitationDetails sharedContentClaimInvitationDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (sharedContentClaimInvitationDetails.sharedContentLink != null) {
                jsonGenerator.writeFieldName("shared_content_link");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sharedContentClaimInvitationDetails.sharedContentLink, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedContentClaimInvitationDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String str = null;
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
                    if ("shared_content_link".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                SharedContentClaimInvitationDetails sharedContentClaimInvitationDetails = new SharedContentClaimInvitationDetails(str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedContentClaimInvitationDetails, sharedContentClaimInvitationDetails.toStringMultiline());
                return sharedContentClaimInvitationDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
