package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.sharing.AccessLevel;
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
public class SharedLinkSettingsChangeAudienceDetails {

    @Nonnull
    protected final LinkAudience newValue;

    @Nullable
    protected final LinkAudience previousValue;

    @Nonnull
    protected final AccessLevel sharedContentAccessLevel;

    @Nullable
    protected final String sharedContentLink;

    public SharedLinkSettingsChangeAudienceDetails(@Nonnull AccessLevel accessLevel, @Nonnull LinkAudience linkAudience, @Nullable String str, @Nullable LinkAudience linkAudience2) {
        if (accessLevel == null) {
            throw new IllegalArgumentException("Required value for 'sharedContentAccessLevel' is null");
        }
        this.sharedContentAccessLevel = accessLevel;
        this.sharedContentLink = str;
        if (linkAudience == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = linkAudience;
        this.previousValue = linkAudience2;
    }

    public SharedLinkSettingsChangeAudienceDetails(@Nonnull AccessLevel accessLevel, @Nonnull LinkAudience linkAudience) {
        this(accessLevel, linkAudience, null, null);
    }

    @Nonnull
    public AccessLevel getSharedContentAccessLevel() {
        return this.sharedContentAccessLevel;
    }

    @Nonnull
    public LinkAudience getNewValue() {
        return this.newValue;
    }

    @Nullable
    public String getSharedContentLink() {
        return this.sharedContentLink;
    }

    @Nullable
    public LinkAudience getPreviousValue() {
        return this.previousValue;
    }

    public static Builder newBuilder(AccessLevel accessLevel, LinkAudience linkAudience) {
        return new Builder(accessLevel, linkAudience);
    }

    public static class Builder {
        protected final LinkAudience newValue;
        protected LinkAudience previousValue;
        protected final AccessLevel sharedContentAccessLevel;
        protected String sharedContentLink;

        protected Builder(AccessLevel accessLevel, LinkAudience linkAudience) {
            if (accessLevel == null) {
                throw new IllegalArgumentException("Required value for 'sharedContentAccessLevel' is null");
            }
            this.sharedContentAccessLevel = accessLevel;
            if (linkAudience == null) {
                throw new IllegalArgumentException("Required value for 'newValue' is null");
            }
            this.newValue = linkAudience;
            this.sharedContentLink = null;
            this.previousValue = null;
        }

        public Builder withSharedContentLink(String str) {
            this.sharedContentLink = str;
            return this;
        }

        public Builder withPreviousValue(LinkAudience linkAudience) {
            this.previousValue = linkAudience;
            return this;
        }

        public SharedLinkSettingsChangeAudienceDetails build() {
            return new SharedLinkSettingsChangeAudienceDetails(this.sharedContentAccessLevel, this.newValue, this.sharedContentLink, this.previousValue);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.sharedContentAccessLevel, this.sharedContentLink, this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        LinkAudience linkAudience;
        LinkAudience linkAudience2;
        String str;
        String str2;
        LinkAudience linkAudience3;
        LinkAudience linkAudience4;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SharedLinkSettingsChangeAudienceDetails sharedLinkSettingsChangeAudienceDetails = (SharedLinkSettingsChangeAudienceDetails) obj;
        AccessLevel accessLevel = this.sharedContentAccessLevel;
        AccessLevel accessLevel2 = sharedLinkSettingsChangeAudienceDetails.sharedContentAccessLevel;
        return (accessLevel == accessLevel2 || accessLevel.equals(accessLevel2)) && ((linkAudience = this.newValue) == (linkAudience2 = sharedLinkSettingsChangeAudienceDetails.newValue) || linkAudience.equals(linkAudience2)) && (((str = this.sharedContentLink) == (str2 = sharedLinkSettingsChangeAudienceDetails.sharedContentLink) || (str != null && str.equals(str2))) && ((linkAudience3 = this.previousValue) == (linkAudience4 = sharedLinkSettingsChangeAudienceDetails.previousValue) || (linkAudience3 != null && linkAudience3.equals(linkAudience4))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedLinkSettingsChangeAudienceDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedLinkSettingsChangeAudienceDetails sharedLinkSettingsChangeAudienceDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("shared_content_access_level");
            AccessLevel.Serializer.INSTANCE.serialize(sharedLinkSettingsChangeAudienceDetails.sharedContentAccessLevel, jsonGenerator);
            jsonGenerator.writeFieldName("new_value");
            LinkAudience.Serializer.INSTANCE.serialize(sharedLinkSettingsChangeAudienceDetails.newValue, jsonGenerator);
            if (sharedLinkSettingsChangeAudienceDetails.sharedContentLink != null) {
                jsonGenerator.writeFieldName("shared_content_link");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sharedLinkSettingsChangeAudienceDetails.sharedContentLink, jsonGenerator);
            }
            if (sharedLinkSettingsChangeAudienceDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(LinkAudience.Serializer.INSTANCE).serialize(sharedLinkSettingsChangeAudienceDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedLinkSettingsChangeAudienceDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            AccessLevel accessLevelDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                LinkAudience linkAudienceDeserialize = null;
                String str = null;
                LinkAudience linkAudience = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("shared_content_access_level".equals(currentName)) {
                        accessLevelDeserialize = AccessLevel.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("new_value".equals(currentName)) {
                        linkAudienceDeserialize = LinkAudience.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("shared_content_link".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        linkAudience = (LinkAudience) StoneSerializers.nullable(LinkAudience.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (accessLevelDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"shared_content_access_level\" missing.");
                }
                if (linkAudienceDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                SharedLinkSettingsChangeAudienceDetails sharedLinkSettingsChangeAudienceDetails = new SharedLinkSettingsChangeAudienceDetails(accessLevelDeserialize, linkAudienceDeserialize, str, linkAudience);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedLinkSettingsChangeAudienceDetails, sharedLinkSettingsChangeAudienceDetails.toStringMultiline());
                return sharedLinkSettingsChangeAudienceDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
