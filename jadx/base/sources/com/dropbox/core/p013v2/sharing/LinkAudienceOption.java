package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.LinkAudience;
import com.dropbox.core.p013v2.sharing.LinkAudienceDisallowedReason;
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

/* JADX INFO: loaded from: classes4.dex */
public class LinkAudienceOption {
    protected final boolean allowed;

    @Nonnull
    protected final LinkAudience audience;

    @Nullable
    protected final LinkAudienceDisallowedReason disallowedReason;

    public LinkAudienceOption(@Nonnull LinkAudience linkAudience, boolean z, @Nullable LinkAudienceDisallowedReason linkAudienceDisallowedReason) {
        if (linkAudience == null) {
            throw new IllegalArgumentException("Required value for 'audience' is null");
        }
        this.audience = linkAudience;
        this.allowed = z;
        this.disallowedReason = linkAudienceDisallowedReason;
    }

    public LinkAudienceOption(@Nonnull LinkAudience linkAudience, boolean z) {
        this(linkAudience, z, null);
    }

    @Nonnull
    public LinkAudience getAudience() {
        return this.audience;
    }

    public boolean getAllowed() {
        return this.allowed;
    }

    @Nullable
    public LinkAudienceDisallowedReason getDisallowedReason() {
        return this.disallowedReason;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.audience, Boolean.valueOf(this.allowed), this.disallowedReason});
    }

    public boolean equals(Object obj) {
        LinkAudienceOption linkAudienceOption;
        LinkAudience linkAudience;
        LinkAudience linkAudience2;
        LinkAudienceDisallowedReason linkAudienceDisallowedReason;
        LinkAudienceDisallowedReason linkAudienceDisallowedReason2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((linkAudience = this.audience) == (linkAudience2 = (linkAudienceOption = (LinkAudienceOption) obj).audience) || linkAudience.equals(linkAudience2)) && this.allowed == linkAudienceOption.allowed && ((linkAudienceDisallowedReason = this.disallowedReason) == (linkAudienceDisallowedReason2 = linkAudienceOption.disallowedReason) || (linkAudienceDisallowedReason != null && linkAudienceDisallowedReason.equals(linkAudienceDisallowedReason2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<LinkAudienceOption> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(LinkAudienceOption linkAudienceOption, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("audience");
            LinkAudience.Serializer.INSTANCE.serialize(linkAudienceOption.audience, jsonGenerator);
            jsonGenerator.writeFieldName("allowed");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(linkAudienceOption.allowed), jsonGenerator);
            if (linkAudienceOption.disallowedReason != null) {
                jsonGenerator.writeFieldName("disallowed_reason");
                StoneSerializers.nullable(LinkAudienceDisallowedReason.Serializer.INSTANCE).serialize(linkAudienceOption.disallowedReason, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public LinkAudienceOption deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            LinkAudience linkAudienceDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize = null;
                LinkAudienceDisallowedReason linkAudienceDisallowedReason = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("audience".equals(currentName)) {
                        linkAudienceDeserialize = LinkAudience.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("allowed".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("disallowed_reason".equals(currentName)) {
                        linkAudienceDisallowedReason = (LinkAudienceDisallowedReason) StoneSerializers.nullable(LinkAudienceDisallowedReason.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (linkAudienceDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"audience\" missing.");
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"allowed\" missing.");
                }
                LinkAudienceOption linkAudienceOption = new LinkAudienceOption(linkAudienceDeserialize, boolDeserialize.booleanValue(), linkAudienceDisallowedReason);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(linkAudienceOption, linkAudienceOption.toStringMultiline());
                return linkAudienceOption;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
