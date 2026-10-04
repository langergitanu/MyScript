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
public class SharedFolderTransferOwnershipDetails {

    @Nonnull
    protected final String newOwnerEmail;

    @Nullable
    protected final String previousOwnerEmail;

    public SharedFolderTransferOwnershipDetails(@Nonnull String str, @Nullable String str2) {
        if (str2 != null && str2.length() > 255) {
            throw new IllegalArgumentException("String 'previousOwnerEmail' is longer than 255");
        }
        this.previousOwnerEmail = str2;
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'newOwnerEmail' is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String 'newOwnerEmail' is longer than 255");
        }
        this.newOwnerEmail = str;
    }

    public SharedFolderTransferOwnershipDetails(@Nonnull String str) {
        this(str, null);
    }

    @Nonnull
    public String getNewOwnerEmail() {
        return this.newOwnerEmail;
    }

    @Nullable
    public String getPreviousOwnerEmail() {
        return this.previousOwnerEmail;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.previousOwnerEmail, this.newOwnerEmail});
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
        SharedFolderTransferOwnershipDetails sharedFolderTransferOwnershipDetails = (SharedFolderTransferOwnershipDetails) obj;
        String str3 = this.newOwnerEmail;
        String str4 = sharedFolderTransferOwnershipDetails.newOwnerEmail;
        return (str3 == str4 || str3.equals(str4)) && ((str = this.previousOwnerEmail) == (str2 = sharedFolderTransferOwnershipDetails.previousOwnerEmail) || (str != null && str.equals(str2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedFolderTransferOwnershipDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedFolderTransferOwnershipDetails sharedFolderTransferOwnershipDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_owner_email");
            StoneSerializers.string().serialize(sharedFolderTransferOwnershipDetails.newOwnerEmail, jsonGenerator);
            if (sharedFolderTransferOwnershipDetails.previousOwnerEmail != null) {
                jsonGenerator.writeFieldName("previous_owner_email");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sharedFolderTransferOwnershipDetails.previousOwnerEmail, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedFolderTransferOwnershipDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    if ("new_owner_email".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("previous_owner_email".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_owner_email\" missing.");
                }
                SharedFolderTransferOwnershipDetails sharedFolderTransferOwnershipDetails = new SharedFolderTransferOwnershipDetails(strDeserialize, str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedFolderTransferOwnershipDetails, sharedFolderTransferOwnershipDetails.toStringMultiline());
                return sharedFolderTransferOwnershipDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
