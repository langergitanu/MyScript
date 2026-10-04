package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.DropboxPasswordsPolicy;
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
public class DropboxPasswordsPolicyChangedDetails {

    @Nonnull
    protected final DropboxPasswordsPolicy newValue;

    @Nonnull
    protected final DropboxPasswordsPolicy previousValue;

    public DropboxPasswordsPolicyChangedDetails(@Nonnull DropboxPasswordsPolicy dropboxPasswordsPolicy, @Nonnull DropboxPasswordsPolicy dropboxPasswordsPolicy2) {
        if (dropboxPasswordsPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = dropboxPasswordsPolicy;
        if (dropboxPasswordsPolicy2 == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = dropboxPasswordsPolicy2;
    }

    @Nonnull
    public DropboxPasswordsPolicy getNewValue() {
        return this.newValue;
    }

    @Nonnull
    public DropboxPasswordsPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        DropboxPasswordsPolicy dropboxPasswordsPolicy;
        DropboxPasswordsPolicy dropboxPasswordsPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        DropboxPasswordsPolicyChangedDetails dropboxPasswordsPolicyChangedDetails = (DropboxPasswordsPolicyChangedDetails) obj;
        DropboxPasswordsPolicy dropboxPasswordsPolicy3 = this.newValue;
        DropboxPasswordsPolicy dropboxPasswordsPolicy4 = dropboxPasswordsPolicyChangedDetails.newValue;
        return (dropboxPasswordsPolicy3 == dropboxPasswordsPolicy4 || dropboxPasswordsPolicy3.equals(dropboxPasswordsPolicy4)) && ((dropboxPasswordsPolicy = this.previousValue) == (dropboxPasswordsPolicy2 = dropboxPasswordsPolicyChangedDetails.previousValue) || dropboxPasswordsPolicy.equals(dropboxPasswordsPolicy2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<DropboxPasswordsPolicyChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(DropboxPasswordsPolicyChangedDetails dropboxPasswordsPolicyChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            DropboxPasswordsPolicy.Serializer.INSTANCE.serialize(dropboxPasswordsPolicyChangedDetails.newValue, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            DropboxPasswordsPolicy.Serializer.INSTANCE.serialize(dropboxPasswordsPolicyChangedDetails.previousValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public DropboxPasswordsPolicyChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            DropboxPasswordsPolicy dropboxPasswordsPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                DropboxPasswordsPolicy dropboxPasswordsPolicyDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        dropboxPasswordsPolicyDeserialize = DropboxPasswordsPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        dropboxPasswordsPolicyDeserialize2 = DropboxPasswordsPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (dropboxPasswordsPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                if (dropboxPasswordsPolicyDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                DropboxPasswordsPolicyChangedDetails dropboxPasswordsPolicyChangedDetails = new DropboxPasswordsPolicyChangedDetails(dropboxPasswordsPolicyDeserialize, dropboxPasswordsPolicyDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(dropboxPasswordsPolicyChangedDetails, dropboxPasswordsPolicyChangedDetails.toStringMultiline());
                return dropboxPasswordsPolicyChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
