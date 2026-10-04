package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.SharedLinkVisibility;
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
public class SharedLinkChangeVisibilityDetails {

    @Nonnull
    protected final SharedLinkVisibility newValue;

    @Nullable
    protected final SharedLinkVisibility previousValue;

    public SharedLinkChangeVisibilityDetails(@Nonnull SharedLinkVisibility sharedLinkVisibility, @Nullable SharedLinkVisibility sharedLinkVisibility2) {
        if (sharedLinkVisibility == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = sharedLinkVisibility;
        this.previousValue = sharedLinkVisibility2;
    }

    public SharedLinkChangeVisibilityDetails(@Nonnull SharedLinkVisibility sharedLinkVisibility) {
        this(sharedLinkVisibility, null);
    }

    @Nonnull
    public SharedLinkVisibility getNewValue() {
        return this.newValue;
    }

    @Nullable
    public SharedLinkVisibility getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        SharedLinkVisibility sharedLinkVisibility;
        SharedLinkVisibility sharedLinkVisibility2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SharedLinkChangeVisibilityDetails sharedLinkChangeVisibilityDetails = (SharedLinkChangeVisibilityDetails) obj;
        SharedLinkVisibility sharedLinkVisibility3 = this.newValue;
        SharedLinkVisibility sharedLinkVisibility4 = sharedLinkChangeVisibilityDetails.newValue;
        return (sharedLinkVisibility3 == sharedLinkVisibility4 || sharedLinkVisibility3.equals(sharedLinkVisibility4)) && ((sharedLinkVisibility = this.previousValue) == (sharedLinkVisibility2 = sharedLinkChangeVisibilityDetails.previousValue) || (sharedLinkVisibility != null && sharedLinkVisibility.equals(sharedLinkVisibility2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedLinkChangeVisibilityDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedLinkChangeVisibilityDetails sharedLinkChangeVisibilityDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            SharedLinkVisibility.Serializer.INSTANCE.serialize(sharedLinkChangeVisibilityDetails.newValue, jsonGenerator);
            if (sharedLinkChangeVisibilityDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(SharedLinkVisibility.Serializer.INSTANCE).serialize(sharedLinkChangeVisibilityDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedLinkChangeVisibilityDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            SharedLinkVisibility sharedLinkVisibilityDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                SharedLinkVisibility sharedLinkVisibility = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        sharedLinkVisibilityDeserialize = SharedLinkVisibility.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        sharedLinkVisibility = (SharedLinkVisibility) StoneSerializers.nullable(SharedLinkVisibility.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (sharedLinkVisibilityDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                SharedLinkChangeVisibilityDetails sharedLinkChangeVisibilityDetails = new SharedLinkChangeVisibilityDetails(sharedLinkVisibilityDeserialize, sharedLinkVisibility);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedLinkChangeVisibilityDetails, sharedLinkChangeVisibilityDetails.toStringMultiline());
                return sharedLinkChangeVisibilityDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
