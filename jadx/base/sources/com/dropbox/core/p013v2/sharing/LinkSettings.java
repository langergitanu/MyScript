package com.dropbox.core.p013v2.sharing;

import androidx.autofill.HintConstants;
import com.dropbox.core.p013v2.sharing.AccessLevel;
import com.dropbox.core.p013v2.sharing.LinkAudience;
import com.dropbox.core.p013v2.sharing.LinkExpiry;
import com.dropbox.core.p013v2.sharing.LinkPassword;
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

/* JADX INFO: loaded from: classes4.dex */
public class LinkSettings {

    @Nullable
    protected final AccessLevel accessLevel;

    @Nullable
    protected final LinkAudience audience;

    @Nullable
    protected final LinkExpiry expiry;

    @Nullable
    protected final LinkPassword password;

    public LinkSettings(@Nullable AccessLevel accessLevel, @Nullable LinkAudience linkAudience, @Nullable LinkExpiry linkExpiry, @Nullable LinkPassword linkPassword) {
        this.accessLevel = accessLevel;
        this.audience = linkAudience;
        this.expiry = linkExpiry;
        this.password = linkPassword;
    }

    public LinkSettings() {
        this(null, null, null, null);
    }

    @Nullable
    public AccessLevel getAccessLevel() {
        return this.accessLevel;
    }

    @Nullable
    public LinkAudience getAudience() {
        return this.audience;
    }

    @Nullable
    public LinkExpiry getExpiry() {
        return this.expiry;
    }

    @Nullable
    public LinkPassword getPassword() {
        return this.password;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected AccessLevel accessLevel = null;
        protected LinkAudience audience = null;
        protected LinkExpiry expiry = null;
        protected LinkPassword password = null;

        protected Builder() {
        }

        public Builder withAccessLevel(AccessLevel accessLevel) {
            this.accessLevel = accessLevel;
            return this;
        }

        public Builder withAudience(LinkAudience linkAudience) {
            this.audience = linkAudience;
            return this;
        }

        public Builder withExpiry(LinkExpiry linkExpiry) {
            this.expiry = linkExpiry;
            return this;
        }

        public Builder withPassword(LinkPassword linkPassword) {
            this.password = linkPassword;
            return this;
        }

        public LinkSettings build() {
            return new LinkSettings(this.accessLevel, this.audience, this.expiry, this.password);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.accessLevel, this.audience, this.expiry, this.password});
    }

    public boolean equals(Object obj) {
        LinkAudience linkAudience;
        LinkAudience linkAudience2;
        LinkExpiry linkExpiry;
        LinkExpiry linkExpiry2;
        LinkPassword linkPassword;
        LinkPassword linkPassword2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        LinkSettings linkSettings = (LinkSettings) obj;
        AccessLevel accessLevel = this.accessLevel;
        AccessLevel accessLevel2 = linkSettings.accessLevel;
        return (accessLevel == accessLevel2 || (accessLevel != null && accessLevel.equals(accessLevel2))) && ((linkAudience = this.audience) == (linkAudience2 = linkSettings.audience) || (linkAudience != null && linkAudience.equals(linkAudience2))) && (((linkExpiry = this.expiry) == (linkExpiry2 = linkSettings.expiry) || (linkExpiry != null && linkExpiry.equals(linkExpiry2))) && ((linkPassword = this.password) == (linkPassword2 = linkSettings.password) || (linkPassword != null && linkPassword.equals(linkPassword2))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<LinkSettings> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(LinkSettings linkSettings, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (linkSettings.accessLevel != null) {
                jsonGenerator.writeFieldName("access_level");
                StoneSerializers.nullable(AccessLevel.Serializer.INSTANCE).serialize(linkSettings.accessLevel, jsonGenerator);
            }
            if (linkSettings.audience != null) {
                jsonGenerator.writeFieldName("audience");
                StoneSerializers.nullable(LinkAudience.Serializer.INSTANCE).serialize(linkSettings.audience, jsonGenerator);
            }
            if (linkSettings.expiry != null) {
                jsonGenerator.writeFieldName("expiry");
                StoneSerializers.nullable(LinkExpiry.Serializer.INSTANCE).serialize(linkSettings.expiry, jsonGenerator);
            }
            if (linkSettings.password != null) {
                jsonGenerator.writeFieldName(HintConstants.AUTOFILL_HINT_PASSWORD);
                StoneSerializers.nullable(LinkPassword.Serializer.INSTANCE).serialize(linkSettings.password, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public LinkSettings deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            AccessLevel accessLevel = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                LinkAudience linkAudience = null;
                LinkExpiry linkExpiry = null;
                LinkPassword linkPassword = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("access_level".equals(currentName)) {
                        accessLevel = (AccessLevel) StoneSerializers.nullable(AccessLevel.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("audience".equals(currentName)) {
                        linkAudience = (LinkAudience) StoneSerializers.nullable(LinkAudience.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("expiry".equals(currentName)) {
                        linkExpiry = (LinkExpiry) StoneSerializers.nullable(LinkExpiry.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if (HintConstants.AUTOFILL_HINT_PASSWORD.equals(currentName)) {
                        linkPassword = (LinkPassword) StoneSerializers.nullable(LinkPassword.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                LinkSettings linkSettings = new LinkSettings(accessLevel, linkAudience, linkExpiry, linkPassword);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(linkSettings, linkSettings.toStringMultiline());
                return linkSettings;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
