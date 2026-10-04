package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.sharing.AccessLevel;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class SharedLinkSettingsAddExpirationDetails {

    @Nullable
    protected final Date newValue;

    @Nonnull
    protected final AccessLevel sharedContentAccessLevel;

    @Nullable
    protected final String sharedContentLink;

    public SharedLinkSettingsAddExpirationDetails(@Nonnull AccessLevel accessLevel, @Nullable String str, @Nullable Date date) {
        if (accessLevel == null) {
            throw new IllegalArgumentException("Required value for 'sharedContentAccessLevel' is null");
        }
        this.sharedContentAccessLevel = accessLevel;
        this.sharedContentLink = str;
        this.newValue = LangUtil.truncateMillis(date);
    }

    public SharedLinkSettingsAddExpirationDetails(@Nonnull AccessLevel accessLevel) {
        this(accessLevel, null, null);
    }

    @Nonnull
    public AccessLevel getSharedContentAccessLevel() {
        return this.sharedContentAccessLevel;
    }

    @Nullable
    public String getSharedContentLink() {
        return this.sharedContentLink;
    }

    @Nullable
    public Date getNewValue() {
        return this.newValue;
    }

    public static Builder newBuilder(AccessLevel accessLevel) {
        return new Builder(accessLevel);
    }

    public static class Builder {
        protected Date newValue;
        protected final AccessLevel sharedContentAccessLevel;
        protected String sharedContentLink;

        protected Builder(AccessLevel accessLevel) {
            if (accessLevel == null) {
                throw new IllegalArgumentException("Required value for 'sharedContentAccessLevel' is null");
            }
            this.sharedContentAccessLevel = accessLevel;
            this.sharedContentLink = null;
            this.newValue = null;
        }

        public Builder withSharedContentLink(String str) {
            this.sharedContentLink = str;
            return this;
        }

        public Builder withNewValue(Date date) {
            this.newValue = LangUtil.truncateMillis(date);
            return this;
        }

        public SharedLinkSettingsAddExpirationDetails build() {
            return new SharedLinkSettingsAddExpirationDetails(this.sharedContentAccessLevel, this.sharedContentLink, this.newValue);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.sharedContentAccessLevel, this.sharedContentLink, this.newValue});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        Date date;
        Date date2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SharedLinkSettingsAddExpirationDetails sharedLinkSettingsAddExpirationDetails = (SharedLinkSettingsAddExpirationDetails) obj;
        AccessLevel accessLevel = this.sharedContentAccessLevel;
        AccessLevel accessLevel2 = sharedLinkSettingsAddExpirationDetails.sharedContentAccessLevel;
        return (accessLevel == accessLevel2 || accessLevel.equals(accessLevel2)) && ((str = this.sharedContentLink) == (str2 = sharedLinkSettingsAddExpirationDetails.sharedContentLink) || (str != null && str.equals(str2))) && ((date = this.newValue) == (date2 = sharedLinkSettingsAddExpirationDetails.newValue) || (date != null && date.equals(date2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedLinkSettingsAddExpirationDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedLinkSettingsAddExpirationDetails sharedLinkSettingsAddExpirationDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("shared_content_access_level");
            AccessLevel.Serializer.INSTANCE.serialize(sharedLinkSettingsAddExpirationDetails.sharedContentAccessLevel, jsonGenerator);
            if (sharedLinkSettingsAddExpirationDetails.sharedContentLink != null) {
                jsonGenerator.writeFieldName("shared_content_link");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sharedLinkSettingsAddExpirationDetails.sharedContentLink, jsonGenerator);
            }
            if (sharedLinkSettingsAddExpirationDetails.newValue != null) {
                jsonGenerator.writeFieldName("new_value");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(sharedLinkSettingsAddExpirationDetails.newValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedLinkSettingsAddExpirationDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            AccessLevel accessLevelDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String str = null;
                Date date = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("shared_content_access_level".equals(currentName)) {
                        accessLevelDeserialize = AccessLevel.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("shared_content_link".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("new_value".equals(currentName)) {
                        date = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (accessLevelDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"shared_content_access_level\" missing.");
                }
                SharedLinkSettingsAddExpirationDetails sharedLinkSettingsAddExpirationDetails = new SharedLinkSettingsAddExpirationDetails(accessLevelDeserialize, str, date);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedLinkSettingsAddExpirationDetails, sharedLinkSettingsAddExpirationDetails.toStringMultiline());
                return sharedLinkSettingsAddExpirationDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
