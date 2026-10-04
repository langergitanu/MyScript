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
public class SharedLinkSettingsRemoveExpirationDetails {

    @Nullable
    protected final Date previousValue;

    @Nonnull
    protected final AccessLevel sharedContentAccessLevel;

    @Nullable
    protected final String sharedContentLink;

    public SharedLinkSettingsRemoveExpirationDetails(@Nonnull AccessLevel accessLevel, @Nullable String str, @Nullable Date date) {
        if (accessLevel == null) {
            throw new IllegalArgumentException("Required value for 'sharedContentAccessLevel' is null");
        }
        this.sharedContentAccessLevel = accessLevel;
        this.sharedContentLink = str;
        this.previousValue = LangUtil.truncateMillis(date);
    }

    public SharedLinkSettingsRemoveExpirationDetails(@Nonnull AccessLevel accessLevel) {
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
    public Date getPreviousValue() {
        return this.previousValue;
    }

    public static Builder newBuilder(AccessLevel accessLevel) {
        return new Builder(accessLevel);
    }

    public static class Builder {
        protected Date previousValue;
        protected final AccessLevel sharedContentAccessLevel;
        protected String sharedContentLink;

        protected Builder(AccessLevel accessLevel) {
            if (accessLevel == null) {
                throw new IllegalArgumentException("Required value for 'sharedContentAccessLevel' is null");
            }
            this.sharedContentAccessLevel = accessLevel;
            this.sharedContentLink = null;
            this.previousValue = null;
        }

        public Builder withSharedContentLink(String str) {
            this.sharedContentLink = str;
            return this;
        }

        public Builder withPreviousValue(Date date) {
            this.previousValue = LangUtil.truncateMillis(date);
            return this;
        }

        public SharedLinkSettingsRemoveExpirationDetails build() {
            return new SharedLinkSettingsRemoveExpirationDetails(this.sharedContentAccessLevel, this.sharedContentLink, this.previousValue);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.sharedContentAccessLevel, this.sharedContentLink, this.previousValue});
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
        SharedLinkSettingsRemoveExpirationDetails sharedLinkSettingsRemoveExpirationDetails = (SharedLinkSettingsRemoveExpirationDetails) obj;
        AccessLevel accessLevel = this.sharedContentAccessLevel;
        AccessLevel accessLevel2 = sharedLinkSettingsRemoveExpirationDetails.sharedContentAccessLevel;
        return (accessLevel == accessLevel2 || accessLevel.equals(accessLevel2)) && ((str = this.sharedContentLink) == (str2 = sharedLinkSettingsRemoveExpirationDetails.sharedContentLink) || (str != null && str.equals(str2))) && ((date = this.previousValue) == (date2 = sharedLinkSettingsRemoveExpirationDetails.previousValue) || (date != null && date.equals(date2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedLinkSettingsRemoveExpirationDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedLinkSettingsRemoveExpirationDetails sharedLinkSettingsRemoveExpirationDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("shared_content_access_level");
            AccessLevel.Serializer.INSTANCE.serialize(sharedLinkSettingsRemoveExpirationDetails.sharedContentAccessLevel, jsonGenerator);
            if (sharedLinkSettingsRemoveExpirationDetails.sharedContentLink != null) {
                jsonGenerator.writeFieldName("shared_content_link");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sharedLinkSettingsRemoveExpirationDetails.sharedContentLink, jsonGenerator);
            }
            if (sharedLinkSettingsRemoveExpirationDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(sharedLinkSettingsRemoveExpirationDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedLinkSettingsRemoveExpirationDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    } else if ("previous_value".equals(currentName)) {
                        date = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (accessLevelDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"shared_content_access_level\" missing.");
                }
                SharedLinkSettingsRemoveExpirationDetails sharedLinkSettingsRemoveExpirationDetails = new SharedLinkSettingsRemoveExpirationDetails(accessLevelDeserialize, str, date);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedLinkSettingsRemoveExpirationDetails, sharedLinkSettingsRemoveExpirationDetails.toStringMultiline());
                return sharedLinkSettingsRemoveExpirationDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
