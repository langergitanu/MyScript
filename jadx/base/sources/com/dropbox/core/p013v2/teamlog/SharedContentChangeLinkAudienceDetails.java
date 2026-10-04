package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.sharing.LinkAudience;
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
public class SharedContentChangeLinkAudienceDetails {

    @Nonnull
    protected final LinkAudience newValue;

    @Nullable
    protected final LinkAudience previousValue;

    public SharedContentChangeLinkAudienceDetails(@Nonnull LinkAudience linkAudience, @Nullable LinkAudience linkAudience2) {
        if (linkAudience == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = linkAudience;
        this.previousValue = linkAudience2;
    }

    public SharedContentChangeLinkAudienceDetails(@Nonnull LinkAudience linkAudience) {
        this(linkAudience, null);
    }

    @Nonnull
    public LinkAudience getNewValue() {
        return this.newValue;
    }

    @Nullable
    public LinkAudience getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        LinkAudience linkAudience;
        LinkAudience linkAudience2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SharedContentChangeLinkAudienceDetails sharedContentChangeLinkAudienceDetails = (SharedContentChangeLinkAudienceDetails) obj;
        LinkAudience linkAudience3 = this.newValue;
        LinkAudience linkAudience4 = sharedContentChangeLinkAudienceDetails.newValue;
        return (linkAudience3 == linkAudience4 || linkAudience3.equals(linkAudience4)) && ((linkAudience = this.previousValue) == (linkAudience2 = sharedContentChangeLinkAudienceDetails.previousValue) || (linkAudience != null && linkAudience.equals(linkAudience2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedContentChangeLinkAudienceDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedContentChangeLinkAudienceDetails sharedContentChangeLinkAudienceDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            LinkAudience.Serializer.INSTANCE.serialize(sharedContentChangeLinkAudienceDetails.newValue, jsonGenerator);
            if (sharedContentChangeLinkAudienceDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(LinkAudience.Serializer.INSTANCE).serialize(sharedContentChangeLinkAudienceDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedContentChangeLinkAudienceDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            LinkAudience linkAudienceDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                LinkAudience linkAudience = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        linkAudienceDeserialize = LinkAudience.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        linkAudience = (LinkAudience) StoneSerializers.nullable(LinkAudience.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (linkAudienceDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                SharedContentChangeLinkAudienceDetails sharedContentChangeLinkAudienceDetails = new SharedContentChangeLinkAudienceDetails(linkAudienceDeserialize, linkAudience);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedContentChangeLinkAudienceDetails, sharedContentChangeLinkAudienceDetails.toStringMultiline());
                return sharedContentChangeLinkAudienceDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
